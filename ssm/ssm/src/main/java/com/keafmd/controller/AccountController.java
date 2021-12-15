package com.keafmd.controller;

import com.keafmd.domain.Account;
import com.keafmd.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    /**
     * 查询所有
     * @param model
     * @return
     */
    @RequestMapping("/findAll")
    public String findAll(Model model){
        System.out.println("表现层，查询所有账户信息。。。");
        //调用service的方法
        List<Account> list = accountService.findAll();
        model.addAttribute("list",list);
        return "list";
    }

    /**
     * 保存
     * @param account
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("/save")
    public void save(Account account, HttpServletRequest request, HttpServletResponse response) throws IOException {
        accountService.saveAccount(account);
        response.sendRedirect(request.getContextPath()+"/account/findAll");
        return;
    }
    /**
         * money up up
         * @param account
         * @param request
         * @param response
         * @throws IOException
         */
        @RequestMapping("/moneyUpUp")
        public void moneyUpUp(HttpServletRequest request, HttpServletResponse response) throws IOException {
                    //调用service的方法
                    accountService.moneyUpUp();
                    response.sendRedirect(request.getContextPath()+"/account/findAll");
                            return;
        }

}