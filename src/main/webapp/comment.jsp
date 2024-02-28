<%@page import="org.apache.commons.lang.StringUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="WEB-INF/views/public/nocache.jsp" %>
<%@include file="WEB-INF/views/public/header.jsp" %>
<!-- 引入相关的js -->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>
<!-- scripts -->
<script src="${pageContext.request.contextPath}/js/particles.min.js"></script>
<script src="${pageContext.request.contextPath}/js/app.js"></script>
<!-- scripts -->
<script src="${pageContext.request.contextPath}/js/jquery-latest.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/theme.js"></script>
<!DOCTYPE html>
<html class="login-bg">
<head>
    <title>评论</title>

    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <!-- bootstrap -->
    <link href="${pageContext.request.contextPath}/css/bootstrap/bootstrap.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/css/bootstrap/bootstrap-responsive.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/css/bootstrap/bootstrap-overrides.css" type="text/css" rel="stylesheet" />

    <!-- global styles -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/layout.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/elements.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/icons.css" />

    <!-- libraries -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/lib/font-awesome.css" />

    <!-- this page specific styles -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/compiled/signin.css" type="text/css" media="screen" />

    <!-- open sans font -->
    <link href='http://fonts.useso.com/css?family=Open+Sans:300italic,400italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css' />

    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>
<body>


<!-- background switcher -->
<div class="bg-switch visible-desktop">
    <div class="bgs">
        <a href="#" data-img="landscape.jpg" class="bg active">
            <img src="${pageContext.request.contextPath}/img/bgs/landscape.jpg" />
        </a>
        <a href="#" data-img="blueish.jpg" class="bg">
            <img src="${pageContext.request.contextPath}/img/bgs/blueish.jpg" />
        </a>
        <a href="#" data-img="7.jpg" class="bg">
            <img src="${pageContext.request.contextPath}/img/bgs/7.jpg" />
        </a>
        <a href="#" data-img="8.jpg" class="bg">
            <img src="${pageContext.request.contextPath}/img/bgs/8.jpg" />
        </a>
        <a href="#" data-img="9.jpg" class="bg">
            <img src="${pageContext.request.contextPath}/img/bgs/9.jpg" />
        </a>
        <a href="#" data-img="10.jpg" class="bg">
            <img src="${pageContext.request.contextPath}/img/bgs/10.jpg" />
        </a>
        <a href="#" data-img="11.jpg" class="bg">
            <img src="${pageContext.request.contextPath}/img/bgs/11.jpg" />
        </a>
    </div>
</div>


<div class="row-fluid login-wrapper">
    <a href="index.html">
        <h3>用户评价</h3>
<%--        <img class="logo" src="${pageContext.request.contextPath}/img/logo-white.png" />--%>
    </a>

    <div class="span4 box">
        <div class="content-wrap">
            <h6>评论</h6>
            <input class="span12" id="username" type="text" placeholder="请输入您的昵称" />
            <input class="span12" id="comment" placeholder="请输入您的评价" />
            <div class="ui-select">
                <select id="commenttarget">
                    <option selected="">Dropdown</option>
                    <option>Custom selects</option>
                    <option>Pure css styles</option>
                </select>
            </div>
            <span class="btn-glow primary login" onclick="submitForm()" >提交</span>
        </div>
    </div>
    <div class="span4 no-account">
        <p>如有疑问，请联系我们的工作人员</p>
    </div>
</div>


<!-- pre load bg imgs -->
<script type="text/javascript">
    $(function () {
        // bg switcher
        var $btns = $(".bg-switch .bg");
        $btns.click(function (e) {
            e.preventDefault();
            $btns.removeClass("active");
            $(this).addClass("active");
            var bg = $(this).data("img");
            $("html").css("background-image", "url('img/bgs/" + bg + "')");
        });
    });
    function submitForm() {
        var uid = maintainerlist [$("#commenttarget")[0].selectedIndex].userid
        var comment = $("#comment").val();
        var username = $("#username").val();
        var data= {
            "uid": uid,
            "comment":comment,
            "username":username
        }
        $.ajax({
            url:"<%=request.getContextPath()%>/baseData/addComment",
            type:"post",
            dataType:"json",
            contentType: 'application/json',
            dataType: "json",
            data: JSON.stringify(data),

        }).done(function(rawdata){
            console.log(rawdata);
            // 在fieldset中添加权限
            var data = rawdata;
            console.log(data);
            var content = "";
            if(data.code ==1 ){
                alert("评价成功!")
            }

        });
    }
    var maintainerlist = [];
    function getuserlist() {
        $.ajax({
            url:"<%=request.getContextPath()%>/baseData/queryUser",
            type:"post",
            dataType:"json"
        }).done(function(rawdata){
            console.log(rawdata);
            // 在fieldset中添加权限
            var data = rawdata;
            var content = "";
            for(var i = 0;i<data.length;i++){
                if( data[i].deptname == "维修部门"){
                    maintainerlist.push(data[i])
                    str = "<option>"+data[i].username+"</option>\n"
                    content += str;
                }
            }
            console.log(content)
            $("#commenttarget").html(content);
            $("#commenttarget").firstChild.attr("selected","")
        });
    }
    getuserlist();
</script>

</body>
</html>