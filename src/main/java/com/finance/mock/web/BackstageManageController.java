package com.finance.mock.web;

import com.finance.mock.entity.Manager;
import com.finance.mock.entity.Module;
import com.finance.mock.entity.Result;
import com.finance.mock.entity.Role;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 快乐水 樱桃可乐
 * @Description:
 * @Date: Created in 9:36 2018/9/22
 * @Modified By:
 */
@Api(tags = "后台-后台管理")
@RestController
@RequestMapping(value = "/manager/background",produces  = "application/json;charset=UTF-8")
public class BackstageManageController {

    /**
     *
     * @Description:   密码管理-更换密码
     * @auther: 快乐水 樱桃可乐
     * @date: 19:34 2018/9/25
     * @param: [usedPassword, newPassword, confirmPassword]
     * @return: com.finance.mock.entity.Result
     *
     */
    @ApiOperation(value = "后台-密码管理-更换密码",notes = "更换密码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "usedPassword",value = "旧密码",dataType = "String",required = true),
            @ApiImplicitParam(name = "newPassword",value = "新密码",dataType = "String",required = true),
            @ApiImplicitParam(name = "confirmPassword",value = "确认新密码",dataType = "String",required = true),
            @ApiImplicitParam(name = "id",value = "账户id",dataType = "long",required = true,paramType = "path")
    })
    @PutMapping(value = "/password/{id}")
    public Result putPassword(@RequestParam String usedPassword,
                              @RequestParam String newPassword,
                              @RequestParam String confirmPassword,
                              @PathVariable long id){
        return new Result(true,"更换密码成功");
    }


    /**
     *
     * @Description: 账户管理：账户列表
     * @auther: 快乐水 樱桃可乐
     * @date: 14:38 2018/9/22
     * @param: [pageNumber]
     * @return: com.finance.mock.entity.Result
     *
     */
    @ApiOperation(value = "后台-账户管理，获取所有账户",notes = "获取所有账户")
    @ApiImplicitParam(name = "pageNumber",value = "页码",dataType = "int",required = true)
    @GetMapping(value = "/accounts")
    public Result getAccounts (@RequestParam int pageNumber){
        List<Manager> managers=new ArrayList<>();
        List<Role> roles=new ArrayList<>();
        Role role1=new Role();
        role1.setRoleName("管理员");
        Role role2=new Role();
        role2.setRoleName("超级管理员");
        roles.add(role1);
        roles.add(role2);
        for(int i=1;i<6;i++){
            Manager manager=new Manager();
            manager.setId(i);
            manager.setSerialId("A00000"+i);
            manager.setAccount("admin"+i);
            manager.setLocked(false);
            manager.setCreatedAt(System.currentTimeMillis());
            manager.setUpdatedAt(System.currentTimeMillis());
            manager.setSerialId("A00000"+i);
            manager.setCreatedBy("创建者"+i);
            manager.setUpdatedBy("更新者"+i);
            manager.setRoles(roles);
            managers.add(manager);
        }
        return new Result(true,managers);
    }

    /**
     *
     * @Description: 账户管理-多表查询
     * @auther: 快乐水 樱桃可乐
     * @date: 14:38 2018/9/22
     * @param: [serialName, roleName, nickName, CreateName]
     * @return: com.finance.mock.entity.Result
     *
     */
    @ApiOperation(value = "后台-账户管理，多条件查询",notes = "多条件查询账户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "serialId",value = "账户ID",dataType = "String",required = true),
            @ApiImplicitParam(name = "roleName",value = "角色名",dataType = "String",required = true),
            @ApiImplicitParam(name = "account",value = "账户名",dataType = "String",required = true),
            @ApiImplicitParam(name = "CreatedBy",value = "创建人",dataType = "String",required = true),
            @ApiImplicitParam(name = "pageNumber",value = "页码",dataType = "int",required = true)
    })
    @GetMapping(value = "/accounts/search")
    public Result getAccountsSearch(@RequestParam String serialId,
                                    @RequestParam String roleName,
                                    @RequestParam String account,
                                    @RequestParam String CreatedBy,
                                    @RequestParam int pageNumber){
        List<Manager> managers=new ArrayList<>();
        List<Role> roles=new ArrayList<>();
        Role role1=new Role();
        role1.setRoleName("管理员");
        Role role2=new Role();
        role2.setRoleName("超级管理员");
        roles.add(role1);
        roles.add(role2);
        for(int i=1;i<6;i++){
            Manager manager=new Manager();
            manager.setId(i);
            manager.setSerialId("A00000"+i);
            manager.setAccount("admin"+i);
            manager.setLocked(false);
            manager.setCreatedAt(System.currentTimeMillis());
            manager.setUpdatedAt(System.currentTimeMillis());
            manager.setSerialId("A00000"+i);
            manager.setCreatedBy("创建者"+i);
            manager.setUpdatedBy("更新者"+i);
            manager.setRoles(roles);
            managers.add(manager);
        }
        return new Result(true,managers);
    }

    /**
     *
     * @Description: 账户管理-添加用户
     * @auther: 快乐水 樱桃可乐
     * @date: 14:38 2018/9/22
     * @param: [nickName, password, roleName, isLocked]
     * @return: com.finance.mock.entity.Result
     *
     */
    @ApiOperation(value = "后台-账户管理，添加账户",notes = "添加账户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "account",value = "账户名",dataType = "String",required = true),
            @ApiImplicitParam(name = "password",value = "密码",dataType = "String",required = true),
            @ApiImplicitParam(name = "roleName",value = "角色名",dataType = "String",required = true),
            @ApiImplicitParam(name = "locked",value = "状态",dataType = "boolean",required = true)
    })
    @PostMapping(value = "/account")
    public Result postAccounts(@RequestParam String account,
                               @RequestParam String password,
                               @RequestParam List<String> roleName,
                               @RequestParam boolean locked){
        return new Result(true,"新增账户成功");
    }

    /**
     *
     * @Description:
     * @auther: 快乐水 樱桃可乐
     * @date: 14:38 2018/9/22
     * @param: [nickName, password, roleName, isLocked, id]
     * @return: com.finance.mock.entity.Result
     *
     */
    @ApiOperation(value = "后台-账户管理，编辑账户",notes = "编辑账户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "account",value = "账户名",dataType = "String",required = true),
            @ApiImplicitParam(name = "password",value = "密码",dataType = "String",required = true),
            @ApiImplicitParam(name = "roleName",value = "角色名",dataType = "String",required = true),
            @ApiImplicitParam(name = "locked",value = "状态",dataType = "boolean",required = true),
            @ApiImplicitParam(name="id",value = "账户ID",dataType = "long",required = true,paramType = "path")
    })
    @PutMapping(value = "/account/{id}")
    public Result putAccounts(@RequestParam String account,
                              @RequestParam String password,
                              @RequestParam List<String> roleName,
                              @RequestParam boolean locked,
                              @PathVariable long id){
        return new Result(true,"编辑账户成功");
    }

    /**
     *
     * @Description:
     * @auther: 快乐水 樱桃可乐
     * @date: 14:39 2018/9/22
     * @param: [id]
     * @return: com.finance.mock.entity.Result
     *
     */
    @ApiOperation(value = "后台-账户管理，删除账户",notes = "删除账户")
    @ApiImplicitParam(name = "id",value = "账户id",dataType = "long",required = true,paramType = "path")
    @DeleteMapping(value = "/account/{id}")
    public Result deleteAccounts(@PathVariable long id){
        return new Result(true,"删除账户成功");
    }

    /**
     *
     * @Description: 后台-账户管理，获取角色列表
     * @auther: 快乐水 樱桃可乐
     * @date: 1:48 2018/9/26
     * @param: []
     * @return: com.finance.mock.entity.Result<java.util.List<com.finance.mock.entity.Role>>
     *
     */
    @ApiOperation(value = "后台-账户管理，获取角色列表",notes = "获取角色")
    @GetMapping("/role")
    public Result<List<Role>> getRole(){
        List<Role> roles=new ArrayList();
        for (int i=1;i<3;i++){
            Role role=new Role();
            role.setRoleName("角色"+i);
            roles.add(role);
        }
        return new Result<List<Role>>(true,roles);
    }

    /**
     *
     * @Description: 后台-角色管理，获取所有角色
     * @auther: 快乐水 樱桃可乐
     * @date: 14:50 2018/9/22
     * @param: [pageNumber]
     * @return: com.finance.mock.entity.Result
     *
     */
    @ApiOperation(value = "后台-角色管理，获取所有角色",notes = "获取所有角色")
    @ApiImplicitParam(name = "pageNumber",value = "页码",dataType = "int",required = true)
    @GetMapping(value = "/roles")
    public Result getRoles(@RequestParam int pageNumber){
        List<Role> roles=new ArrayList<>();
        for(int i=1;i<6;i++){
            Role role=new Role();
            role.setId(i);
            role.setCreatedAt(System.currentTimeMillis());
            role.setRoleName("角色"+i);
            role.setSerialId("P00000"+i);
            role.setUpdatedAt(System.currentTimeMillis());
            role.setUpdatedBy("更新人"+i);
            role.setCreatedBy("创建人"+i);
            roles.add(role);
        }
        return new Result(true,roles);
    }

    /**
     *
     * @Description: 后台-角色管理，多条件查询角色
     * @auther: 快乐水 樱桃可乐
     * @date: 14:53 2018/9/22
     * @param: [serialName, roleName, updateName, CreateName]
     * @return: com.finance.mock.entity.Result
     *
     */
    @ApiOperation(value = "后台-角色管理，多条件查询角色",notes = "多条件查询角色")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "serialId",value = "角色ID",dataType = "String",required = true),
            @ApiImplicitParam(name = "roleName",value = "角色",dataType = "String",required = true),
            @ApiImplicitParam(name = "updatedBy",value = "更新人",dataType = "String",required = true),
            @ApiImplicitParam(name = "CreatedBy",value = "创建人",dataType = "String",required = true),
            @ApiImplicitParam(name = "pageNumber",value = "页码",dataType = "int",required = true)
    })
    @GetMapping(value = "/roles/search")
    public Result getRolesSearch(@RequestParam String serialId,
                                 @RequestParam String roleName,
                                 @RequestParam String updatedBy,
                                 @RequestParam String CreatedBy,
                                 @RequestParam int pageNumber){
        List<Role> roles=new ArrayList<>();
        for(int i=1;i<6;i++){
            Role role=new Role();
            role.setId(i);
            role.setCreatedAt(System.currentTimeMillis());
            role.setRoleName("角色"+i);
            role.setSerialId("P00000"+i);
            role.setUpdatedAt(System.currentTimeMillis());
            role.setUpdatedBy("更新人"+i);
            role.setCreatedBy("创建人"+i);
            roles.add(role);
        }
        return new Result(true,roles);
    }

    /**
     *
     * @Description: 后台-角色管理，添加角色
     * @auther: 快乐水 樱桃可乐
     * @date: 15:00 2018/9/22
     * @param: [roleName, moduleName]
     * @return: com.finance.mock.entity.Result
     *
     */
    @ApiOperation(value = "后台-角色管理，添加角色",notes = "添加角色")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "roleName",value = "角色名",dataType = "String",required = true),
            @ApiImplicitParam(name = "moduleName",value = "模块(权限)名",dataType = "String",required = true)
    })
    @PostMapping(value = "/role")
    public Result postRole(@RequestParam String roleName,
                           @RequestParam List<String> moduleName){
        return new Result(true,"新增角色成功");
    }

    /**
     *
     * @Description: 后台-角色管理，编辑角色
     * @auther: 快乐水 樱桃可乐
     * @date: 15:02 2018/9/22
     * @param: [roleName, moduleName, id]
     * @return: com.finance.mock.entity.Result
     *
     */
    @ApiOperation(value = "后台-角色管理，编辑角色",notes = "编辑角色")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "roleName",value = "角色名",dataType = "String",required = true),
            @ApiImplicitParam(name = "moduleName",value = "模块(权限)名",dataType = "String",required = true),
            @ApiImplicitParam(name = "id",value = "模块id",dataType = "String",required = true,paramType = "path")
    })
    @PutMapping(value = "/role/{id}")
    public Result putRole(@RequestParam String roleName,
                          @RequestParam String moduleName,
                          @PathVariable long id){
        return new Result(true,"编辑角色成功");
    }

    /**
     *
     * @Description: 后台-角色管理，删除角色
     * @auther: 快乐水 樱桃可乐
     * @date: 15:13 2018/9/22
     * @param: [id]
     * @return: com.finance.mock.entity.Result
     *
     */
    @ApiOperation(value = "后台-角色管理，删除角色",notes = "删除角色")
    @ApiImplicitParam(name = "id",value = "角色id",dataType = "String",required = true,paramType = "path")
    @DeleteMapping(value = "/role/{id}")
    public Result deleteRole(@PathVariable long id){
        return new Result(true,"删除角色成功");
    }




    /**
     *
     * @Description: 后台-模块管理-模块列表
     * @auther: 快乐水 樱桃可乐
     * @date: 15:13 2018/9/22
     * @param: [pageNumber]
     * @return: com.finance.mock.entity.Result
     *
     */
    @ApiOperation(value = "后台-模块管理，获取所有模块",notes = "获取所有模块")
    @ApiImplicitParam(name = "pageNumber",value = "页码",dataType = "int",required = true)
    @GetMapping(value = "/modules")
    public Result getModules(@RequestParam int pageNumber){
        List<Module> modules=new ArrayList<>();
        for(int i=1;i<6;i++){
            Module module=new Module();
            module.setId(i);
            module.setCreateAt(System.currentTimeMillis());
            module.setCreatedBy("CreateName");
            module.setFatherModuleId(i);
            module.setModuleName("SonModule"+i);
            module.setModuleType("ModuleType"+i);
            module.setModuleUrl("ModuleUrl"+i);
            module.setSerialId("M00000"+i);
            module.setUpdateAt(System.currentTimeMillis());
            module.setUpdatedBy("UpdateName"+i);
            modules.add(module);
        }
        return new Result(true,modules);
    }

    /**
     *
     * @Description: 后台-模块管理-多条件查询
     * @auther: 快乐水 樱桃可乐
     * @date: 15:13 2018/9/22
     * @param: [serialName, moduleName, fatherModule, CreateName]
     * @return: com.finance.mock.entity.Result
     *
     */
    @ApiOperation(value = "后台-模块管理，多条件查询模块",notes = "多条件查询模块")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "serialId",value = "模块ID",dataType = "String",required = true),
            @ApiImplicitParam(name = "moduleName",value = "模块名",dataType = "String",required = true),
            @ApiImplicitParam(name = "fatherModule",value = "父模块",dataType = "String",required = true),
            @ApiImplicitParam(name = "CreatedBy",value = "创建人",dataType = "String",required = true),
            @ApiImplicitParam(name = "pageNumber",value = "页码",dataType = "int",required = true)
    })
    @GetMapping(value = "/modules/search")
    public Result getModulesSearch(@RequestParam String serialId,
                                   @RequestParam String moduleName,
                                   @RequestParam String fatherModule,
                                   @RequestParam String CreatedBy,
                                   @RequestParam int pageNumber){
        List<Module> modules=new ArrayList<>();
        for(int i=1;i<6;i++){
            Module module=new Module();
            module.setId(i);
            module.setCreateAt(System.currentTimeMillis());
            module.setCreatedBy("CreateName");
            module.setFatherModuleId(i);
            module.setModuleName("SonModule"+i);
            module.setModuleType("ModuleType"+i);
            module.setModuleUrl("ModuleUrl"+i);
            module.setSerialId("M00000"+i);
            module.setUpdateAt(System.currentTimeMillis());
            module.setUpdatedBy("UpdateName"+i);
            modules.add(module);
        }
        return new Result(true,modules);
    }

    /**
     *
     * @Description: 后台-模块管理，添加模块
     * @auther: 快乐水 樱桃可乐
     * @date: 15:13 2018/9/22
     * @param: [moduleName, moduleUrl, id, moduleType]
     * @return: com.finance.mock.entity.Result
     *
     */
    @ApiOperation(value = "后台-模块管理，添加模块",notes = "添加模块")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "moduleName",value = "模块名",dataType = "String",required = true),
            @ApiImplicitParam(name = "moduleUrl",value = "URL地址",dataType = "String",required = true),
            @ApiImplicitParam(name = "id",value = "父模块ID",dataType = "long",required = true),
            @ApiImplicitParam(name = "moduleType",value = "模块类型",dataType = "String",required = true)
    })
    @PostMapping(value = "/module/{id}")
    public Result postModule(@RequestParam String moduleName,
                             @RequestParam String moduleUrl,
                             @RequestParam long id,
                             @RequestParam String moduleType){
        return new Result(true,"新增模块成功");
    }

    /**
     *
     * @Description: 后台-模块管理，编辑模块
     * @auther: 快乐水 樱桃可乐
     * @date: 15:13 2018/9/22
     * @param: [moduleName, moduleUrl, fatherId, moduleType, id]
     * @return: com.finance.mock.entity.Result
     *
     */
    @ApiOperation(value = "后台-模块管理，编辑模块",notes = "编辑模块")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "moduleName",value = "模块名",dataType = "String",required = true),
            @ApiImplicitParam(name = "moduleUrl",value = "URL地址",dataType = "String",required = true),
            @ApiImplicitParam(name = "fatherId",value = "父模块ID",dataType = "long",required = true),
            @ApiImplicitParam(name = "moduleType",value = "模块类型",dataType = "String",required = true),
            @ApiImplicitParam(name = "id",value = "模块id",dataType = "String",required = true,paramType = "path")
    })
    @PutMapping(value = "/module/{id}")
    public Result putModule(@RequestParam String moduleName,
                            @RequestParam String moduleUrl,
                            @RequestParam long fatherId,
                            @RequestParam String moduleType,
                            @PathVariable long id){
        return new Result(true,"编辑模块成功");
    }

    /**
     *
     * @Description: 后台-模块管理，删除模块
     * @auther: 快乐水 樱桃可乐
     * @date: 15:14 2018/9/22
     * @param: [id]
     * @return: com.finance.mock.entity.Result
     *
     */
    @ApiOperation(value = "后台-模块管理，删除模块",notes = "删除模块")
    @ApiImplicitParam(name = "id",value = "模块id",dataType = "String",required = true,paramType = "path")
    @DeleteMapping(value = "/module/{id}")
    public Result deleteModule(@PathVariable long id){
        return new Result(true,"删除模块成功");
    }
}
