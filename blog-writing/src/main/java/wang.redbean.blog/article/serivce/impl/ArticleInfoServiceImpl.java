package wang.redbean.blog.article.serivce.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import wang.redbean.blog.article.mapper.ArticleInfoMapper;
import wang.redbean.blog.article.model.entity.ArticleInfo;
import wang.redbean.blog.article.model.entity.ArticleRecived;
import wang.redbean.blog.article.serivce.IArticleInfoService;
import wang.redbean.blog.utils.FileUtil;
import wang.redbean.blog.utils.ValidationUtil;
import java.util.List;

/**
 *文章详情业务实现类
 */
@Service
public class ArticleInfoServiceImpl extends ServiceImpl<ArticleInfoMapper, ArticleInfo> implements IArticleInfoService {

    /**
     * 新增一篇文章
     */
    @Override
    public boolean insert(ArticleRecived articleRecived, MultipartFile file) {
        //上传图片功能
        articleRecived.setArticleIcon(FileUtil.upload(file,"D:\\").toString());
        return ValidationUtil.retBool(baseMapper.save(articleRecived));
    }

    /**
     * 根据id删除一篇文章
     */
    @Override
    public boolean deleteByIds(List<Long> idList) {
        //删除文章信息
        return ValidationUtil.retBool(baseMapper.deleteBatchIds(idList));
    }



}
