package cn.springmvc.controller;


import cn.springmvc.model.TParmeters;
import cn.springmvc.service.impl.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.UUID;

@Controller
@RequestMapping(value = "/parameters")
public class TestParametersController {
    @Resource(name = "parmetersService")
    private BaseService baseService;
    @Autowired
    private HttpServletRequest request;


    @RequestMapping(value = "/list.do")
    public String caselist(Integer pag,Integer pagesize){
        request.setAttribute("data",baseService.list(pag,pagesize));
        return "parameters/parametersList";
    }
    @RequestMapping(value = "/toadd.do")
    public String toadd(){
        //request.setAttribute("objs", funcService.toadd());
        System.out.println("hahhh");
        return "parameters/addParameters";
    }
    @RequestMapping(value = "/add.do")
    public String addfunc(TParmeters tParmeters)  {
        tParmeters.setUid(UUID.randomUUID().toString());
        baseService.add(tParmeters);
        return "redirect:list.do";
    }



    @RequestMapping(value = "/toupdate.do")
    public String toupdate(String id){
        request.setAttribute("data", baseService.getById(id));

        return "parameters/updateParmeters";
    }

    @RequestMapping(value = "/update.do")
    public String update(TParmeters system){
        baseService.update(system);
        return "redirect:list.do";
    }
}
