package wang.redbean.blog.article.serivce.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import wang.redbean.blog.article.entity.ArticleContent;
import wang.redbean.blog.article.entity.ArticleInfo;
import wang.redbean.blog.article.entity.ArticleRecived;
import wang.redbean.blog.article.mapper.ArticleInfoMapper;
import wang.redbean.blog.article.serivce.IArticleInfoService;
import wang.redbean.blog.common.util.Tools;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 *文章详情业务实现类
 */
@Service
public class ArticleInfoServiceImpl extends ServiceImpl<ArticleInfoMapper, ArticleInfo> implements IArticleInfoService {



    /**
     * 新增
     * @param articleInfo
     * @return
     */
    public boolean save(ArticleInfo articleInfo){
        return super.save(articleInfo);
    }

    /**
     * 新增一篇文章
     * @param articleRecived
     * @return
     */
    @Override
    public Integer insert(ArticleRecived articleRecived, MultipartFile file) {
        //上传图片功能
        articleRecived.setArticleIcon(Tools.uploadPic(file,"D://mypro//web_log//articlePic//",articleRecived.getArticleName()));
        articleRecived.setArticleStatus(0);
        Integer result = baseMapper.save(articleRecived);
        return result;
    }

    /**
     * 根据id删除一篇文章
     * @param idList
     * @return
     */
    @Override
    public Integer deleteByIds(List<Integer> idList) {
        Integer result = baseMapper.deleteByIds(idList);//删除文章信息
        //删除文章正文
        return result;
    }

    /**
     * 根据id修改文章信息
     * @param articleInfo
     * @return
     */
    @Override
    public Integer updateInfoById(ArticleInfo articleInfo) {
        Integer result = baseMapper.updateInfoById(articleInfo);
        return result;
    }

    /**
     * 查询全部文章
     * @return
     */
    @Override
    public List<ArticleInfo> findAll() {
        List<ArticleInfo> articleInfoList = baseMapper.findAll();
        return articleInfoList;
    }

    @Override
    public List<ArticleInfo> getByParam(HttpServletRequest request, ArticleInfo articleInfo) {
        Date startTime = Tools.StringToDate(request.getParameter("startTime"));
        Date endTime = Tools.StringToDate(request.getParameter("endTime"));
        System.out.println("status:"+articleInfo.getArticleStatus());
        List<ArticleInfo> articleInfoList = baseMapper.getByParam(articleInfo,startTime,endTime);
        return articleInfoList;
    }

}
