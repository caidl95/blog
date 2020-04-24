package wang.redbean.blog.weixin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import wang.redbean.blog.base.controller.BaseController;
import wang.redbean.blog.base.exception.BadRequestException;
import wang.redbean.blog.weixin.model.UserAccessToken;
import wang.redbean.blog.weixin.model.WechatUser;
import wang.redbean.blog.weixin.service.IWechatService;
import wang.redbean.blog.weixin.utils.WechatUtil;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 获取关注公众号之后的微信用户信息的接口，如果在微信浏览器里访问
 * https://open.weixin.qq.com/connect/oauth2/authorize?appid=您的appId&redirect_uri=http://o2o.yitiaojieinfo.com/o2o/wechatlogin/logincheck&role_type=1&response_type=code&scope=snsapi_userinfo&state=1#wechat_redirect
 * 则这里将会获取到code,之后再可以通过code获取到access_token 进而获取到用户信息
 */

@Controller
@RequestMapping("/wechat")
public class WechatLoginController extends BaseController<IWechatService, WechatUser> {

    private static Logger log = LoggerFactory.getLogger(WechatLoginController.class);

    @RequestMapping("/getOpenId")
    public String doGet(HttpServletRequest request, HttpServletResponse response, String code){
        log.debug("weixin login code:" + code);
        WechatUser user = null;
        String openId;
        if (null != code) {
            UserAccessToken token;
            try {
                // 通过code获取access_token
                token = WechatUtil.getUserAccessToken(code);
                log.debug("weixin login token:" + token.toString());
                // 通过token获取accessToken
                String accessToken = token.getAccessToken();
                // 通过token获取openId
                openId = token.getOpenId();
                // 通过openId在数据库中查询用户信息
                user = baseService.selectByOpenId(openId);
                if (user == null) {
                    // 通过access_token和openId获取用户昵称等信息
                    user = WechatUtil.getUserInfo(accessToken, openId);
                    boolean result = baseService.save(user);
                    if (result)
                        throw new BadRequestException("新增微信用户时出现未知异常！");
                }
                //查询用户是否关注公众号
                if (WechatUtil.getUserSubscribe(accessToken, openId))
                    System.err.println("用户未关注！");
                log.debug("weixin login user:" + user.toString());
                //TODO openId 存入session
                request.getSession().setAttribute("openId", openId);

            } catch (IOException e) {
                log.error("error in getUserAccessToken or getUserInfo or findByOpenId: " + e.toString());
                e.printStackTrace();
            }
        }
        if (user != null) {
            // 获取到微信验证的信息后返回到指定的路由（需要自己设定）
            return "frontend/index";
        } else {
            return null;
        }
    }



  /*  @RequestMapping("loginInit")
    public String loginInit(HttpServletRequest request,HttpServletResponse response)  {
        //回调地址,要跟下面的地址能调通(getWechatGZAccessToken.do)
        String backUrl="http://www.redbean.wang/weixin/getOpenId";
        //AuthUtil.APPID微信公众号的appId
        String url = null;
        try {
            url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + AuthUtil.APPID+
                    "&redirect_uri=" + URLEncoder.encode(backUrl,"UTF-8")+
                    "&response_type=code" +
                    "&scope=snsapi_userinfo" +
                    "&state=STATE#wechat_redirect";
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "redirect:"+url;
    }*/


/*    public String getWechatGZAccessToken(HttpServletRequest request,HttpServletResponse response) throws Exception{
        //微信公众号的APPID和APPSECRET
        String code=request.getParameter("code");
        String url="https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + AuthUtil.APPID+
                "&secret=" +AuthUtil.APPSECRET+
                "&code=" +code+
                "&grant_type=authorization_code";
        String result = HttpClientManager.getUrlData(url);
        System.err.println(result);
        JSONObject jsonObject = JSONObject.parseObject(result);
        String openId = jsonObject.getString("openid");
        String token = jsonObject.getString("access_token");
        System.err.println(openId+"   openId+token   "+token);
        //Map<String,Object> data = JSONObject.fromObject(result);
        //String openid=data.get("openid").toString();
       // String token=data.get("access_token").toString();
        //获取信息
        String infoUrl="https://api.weixin.qq.com/sns/userinfo?access_token=" +token+
                "&openid=" +openId+
                "&lang=zh_CN";
        String infoResult = HttpClientManager.getUrlData(infoUrl);
        System.err.println(" 最终响应结果 "+infoResult);
        return null;
    }*/

}
