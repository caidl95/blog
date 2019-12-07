package wang.redbean.blog.article.serivce.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import wang.redbean.blog.article.entity.ArticleInfo;
import wang.redbean.blog.article.mapper.ArticleInfoMapper;
import wang.redbean.blog.article.serivce.IArticleInfoService;

/**
 *文章详情业务实现类
 */
@Service
public class ArticleInfoServiceImpl extends ServiceImpl<ArticleInfoMapper, ArticleInfo> implements IArticleInfoService {

}
