package wang.redbean.blog.article.controller;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import wang.redbean.blog.article.model.entity.Category;
import wang.redbean.blog.article.serivce.ICategoryService;
import wang.redbean.blog.base.controller.BaseController;
import wang.redbean.blog.base.entity.response.ServerResponse;
import wang.redbean.blog.log.Log;

@RestController
@RequestMapping("/category")
@Api("分类")
public class CategoryController extends BaseController<ICategoryService, Category> {

    @Log("新增分类")
    @ApiOperation("新增分类")
    @PostMapping("/save")
    public ServerResponse addCategory(Category category){
        return super.save(category);
    }

    @Log("修改分类")
    @ApiOperation("修改分类")
    @PostMapping("/update")
    public ServerResponse update( Category category){
        return super.update(category);
    }

    @Log("根据id删除分类")
    @ApiOperation("根据id删除分类")
    @PostMapping("/{id}/delete")
    public ServerResponse delete(@PathVariable("id")Long id){
      return ServerResponse.isSuccess( baseService.removeById(id));
    }

    @ApiOperation("根据id查询分类")
    @GetMapping("/{id}/select")
    public ServerResponse select(@PathVariable("id")Long id){
        return super.getById(id);
    }

    @ApiOperation("根据categoryId获取当前categoryId子节点并且是平级的无递归的Category信息")
    @GetMapping("/select")
    public ServerResponse getChildrenParallelCategory(@RequestParam(value = "categoryId" ,defaultValue = "0")Long categoryId){
        //查询子节点的category信息，并且不递归，保持平级
        return ServerResponse.success(baseService.getChildrenParallelCategory(categoryId));
    }

    @ApiOperation("查询子当前节点的id和递归子节点的id")
    @GetMapping("/select_deep")
    public ServerResponse getCategoryAndDeepChildrenCategory(@RequestParam(value = "categoryId" ,defaultValue = "0")Long categoryId){
        return ServerResponse.success(baseService.selectCategoryAndChildrenById(categoryId));
    }

}
