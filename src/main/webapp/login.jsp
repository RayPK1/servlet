<%@page import="common.Process"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Đăng nhập</title>
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet"
            href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
    </head>
    <body>
        <div class="container-fluid sticky-top bg p-1">
            <div class="row">
                <div class="container">
                    <div class="row">
                        <div class="col-auto m-auto">
                            <a href="#"><img src="photo/logoray.png"
                                    width="50px"
                                    alt="hi"></a>
                            <h1 class="float-end ps-5">Bán hàng</h1>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="container mt-5">
            <h1 class="text-center m-3">Đăng nhập</h1>
            <div class="row">
                <div class="col-8 offset-2">
                    <form action="CheckLoginServlet" method="POST">
                        <div class="row mb-3">
                            <label for="taiKhoan" class="col-3 col-form-label fw-bold">Tên đăng nhập</label>
                            <div class="col-9">
                                <input class="form-control bg-body"
                                    type="text"  name="taiKhoan" id="taiKhoan">
                            </div>
                        </div>
                        <div class="row mb-3">
                            <label for="matKhau" class="col-3 col-form-label fw-bold">Mật khẩu</label>
                            <div class="col-9">
                                <input class="form-control bg-body"
                                    type="password" name="matKhau" id="matKhau">
                            </div>
                        </div>
                         <div class="row mb-3 justify-content-end" style="color:red">
                         <%
								String error = request.getParameter("error");
								%>
								<%=("1".equals(error)) ? "Mời bạn đăng nhập!" : ""%>
                         <%=Process.getVaildString((String)request.getAttribute("thongBao"))%>
                         </div>
                        <div class="row">
                            <div class="col-4 offset-8">
                                <button type="submit" class="btn btn-dark bg">Xác nhận</button>
                                <button type="reset" class="btn btn-dark bg">Hủy bỏ</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
            <footer>
                <div class="container-fluid bg mt-5">
                    <div class="row">
                        <div class="col-1 offset-4">
                            <a class="face" href="#"><i class="bi bi-facebook"></i>
                                FACEBOOK</a>
                        </div>
                        <div class="col-1">
                            <a class="link" href="#"><i class="bi bi-linkedin"></i>
                                LINKEDIN</a>
                        </div>

                        <div class="col-1">
                            <a class="git" href="#"><i class="bi bi-github"></i>
                                GITHUB</a>
                        </div>
                        <div class="col-1">
                            <a class="twi" href="#"><i class="bi bi-twitter"></i>
                                TWITTER</a>
                        </div>
                    </div>
                </div>
            </footer>
            <script src="js/JQuery-3.7.0.min.js"></script>
            <script src="js/bootstrap.min.js"></script>
            <script src="js/main.js"></script>
    </body>
</html>