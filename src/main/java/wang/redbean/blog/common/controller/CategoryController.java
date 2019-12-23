package wang.redbean.blog.common.controller;

import org.springframework.web.bind.annotation.*;
import wang.redbean.blog.common.entity.Category;
import wang.redbean.blog.common.service.ICategoryService;
import wang.redbean.blog.core.base.controller.BaseController;
import wang.redbean.blog.core.base.entity.response.ServerResponse;

@RestController
@RequestMapping("/category")
public class CategoryController extends BaseController<ICategoryService> {

    /**
     * 添加品类
     */
    @PostMapping("/save")
    public ServerResponse addCategory( Category category){
        boolean result = service.save(category);
        if (result)
            return ServerResponse.createBySuccess("新增分类成功！");
        return ServerResponse.createByErrorMessage("新增分类失败");
    }

    /**
     * 更新categoryName
     * 品类名称
     */
    @PostMapping("/update")
    public ServerResponse setCategoryName( Category category){
        boolean result = service.updateById( category);
        if (result)
            return ServerResponse.createBySuccess("修改分类成功！");
        return ServerResponse.createByErrorMessage("修改分类失败");
    }

    @PostMapping("/{id}/delete")
    public ServerResponse delete(@PathVariable("id")Integer id){
        boolean result = service.removeById(id);
        if (result)
            return ServerResponse.createBySuccess("删除分类成功！");
        return ServerResponse.createByErrorMessage("删除分类失败");
    }

    @GetMapping("/{id}/select")
    public ServerResponse select(@PathVariable("id")Integer id){
        return ServerResponse.createBySuccess(service.getById(id));
    }


    /**
     * 根据categoryId获取当前categoryId子节点并且是平级的无递归的Category信息
     */
    @GetMapping("/select")
    public ServerResponse getChildrenParallelCategory(@RequestParam(value = "categoryId" ,defaultValue = "0")Integer categoryId){
        //查询子节点的category信息，并且不递归，保持平级
        return ServerResponse.createBySuccess(service.getChildrenParallelCategory(categoryId));
    }

    /**
     *查询子当前节点的id和递归子节点的id
     */
    @GetMapping("/select_deep")
    public ServerResponse getCategoryAndDeepChildrenCategory(@RequestParam(value = "categoryId" ,defaultValue = "0")Integer categoryId){
        return ServerResponse.createBySuccess(service.selectCategoryAndChildrenById(categoryId));
    }

}
