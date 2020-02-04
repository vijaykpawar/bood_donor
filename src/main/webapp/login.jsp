<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<%
   response.addHeader("Cache-Control", "no-cache,no-store,private,must-revalidate,max-stale=0,post-check=0,pre-check=0"); 
   response.addHeader("Pragma", "no-cache"); 
   response.addDateHeader ("Expires", 0);
   %>
<title>Welcome to Admin Portal</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
        <!-- bootstrap 3.0.2 -->
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <!-- font Awesome -->
        <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css" />
        <!-- Theme style -->
        <link href="css/style.css" rel="stylesheet" type="text/css" />

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
        <![endif]-->
</head>
 <body class="bg-black" style="height: 800px">

        <div class="form-box" id="login-box">
            <div class="header">Sign In</div>
            <s:form action="signIn" name="logInUser" enctype="multipart/form-data" theme="bootstrap">
                <div class="body bg-gray">
                    <div class="form-group">
                       <!--  <input type="text" name="userid" class="form-control" placeholder="User ID"/> -->
                        <s:textfield name="username" class="form-control" placeholder="User Name"></s:textfield>
                    </div>
                    <div class="form-group">
                        <!-- <input type="password" name="password" class="form-control" placeholder="Password"/> -->
                        <s:password name="password" class="form-control" placeholder="Password"></s:password>
                    </div>          
                    
                </div>
                <div class="footer">                                                               
                    <s:submit cssClass="btn bg-olive btn-block"/>
                </div>
            </s:form>

            <div class="margin text-center">
               
            </div>
        </div>


        <!-- jQuery 2.0.2 -->
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
        <!-- Bootstrap -->
        <script src="js/bootstrap.min.js" type="text/javascript"></script>        

    </body>
</html>