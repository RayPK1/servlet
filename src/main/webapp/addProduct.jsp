<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>SHOP</title>
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet"
            href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
    </head>
    <body>
	    <%
		if (session.getAttribute("UserName") == null) {
			response.sendRedirect("login.jsp?error=1");
		} else {
			String mess = request.getParameter("message");
		%>
		<% String TenSP = request.getParameter("TenSP") != null ? request.getParameter("TenSP") : ""; %>
		<% String SoLuong= request.getParameter("SoLuong") != null ? request.getParameter("SoLuong") : "0"; %>
		<% String DonGia = request.getParameter("DonGia") != null ? request.getParameter("DonGia") : "0.0"; %>
		<% String HinhAnh = request.getParameter("HinhAnh") != null ? request.getParameter("HinhAnh") : ""; %>
		<% String DonViTinh = request.getParameter("DonViTinh") != null ? request.getParameter("DonViTinh") : ""; %>
		<input id="mess" type="hidden" value="<%=mess%>">
        <div class="container-fluid sticky-top bg p-1">
            <div class="row">
                <div class="container">
                    <div class="row">
                        <div class="col-auto m-auto">
						<a href="#"><img src="photo/logoray.png" width="32px"
							height="32px" alt="hi"></a>
						<h1 class="float-end ps-5">Cửa hàng</h1>
					</div>
                        <div class="col-2">
						<button type="button" class="btn btn-outline-light">
							<i class="bi bi-person-circle"></i>
							<%=session.getAttribute("UserName")%>
						</button>
						<a href="LogOutServlet" class="btn btn-outline-light"><i
							class="bi bi-door-open"></i>Đăng xuất</a>
					</div>
                    </div>
                </div>
            </div>
        </div>
        <div class="container mt-3">
            <div class="row">
                <h1 class="text-center m-3">Thêm Sản phẩm</h1>
                <form action="ShowCreateProductServlet" method="post">
                    <div class="col-9 m-3">
                        <div class="row">
                            <label for="TenSP"
                                class="col-2 offset-1 col-form-label fw-bold">
                                Tên sản phẩm
                            </label>
                            <div class="col-9">
                                <input type="text" name="TenSP"
                                    class="form-control" required value="<%=TenSP%>">
                            </div>
                        </div>
                    </div>
                    <div class="col-9 m-3">
                        <div class="row">
                            <label for="SoLuong"
                                class="col-2 offset-1 col-form-label fw-bold">
                                Số lượng
                            </label>
                            <div class="col-9">
                                <input type="text" name="SoLuong"
                                    class="form-control" required value="<%=SoLuong%>">
                            </div>
                        </div>
                    </div>
                    <div class="col-9 m-3">
                        <div class="row">
                            <label for="DonGia"
                                class="col-2 offset-1 col-form-label fw-bold">
                                Đơn giá
                            </label>
                            <div class="col-9">
                                <input type="text" name="DonGia"
                                    class="form-control" required value="<%=DonGia%>">
                            </div>
                        </div>
                    </div>
                    <div class="col-9 m-3">
                        <div class="row">
                            <label for="HinhAnh"
                                class="col-2 offset-1 col-form-label fw-bold">
                                Hình ảnh
                            </label>
                            <div class="col-9">
                                <input type="text" name="HinhAnh"
                                    class="form-control" required value="<%=HinhAnh%>">
                            </div>
                        </div>
                    </div>
                    <div class="col-9 m-3">
                        <div class="row">
                            <label for="DonViTinh"
                                class="col-2 offset-1 col-form-label fw-bold">
                                Đơn Vị Tính
                            </label>
                            <div class="col-9">
                                <input type="text" name="DonViTinh"
                                    class="form-control" required value="<%=DonViTinh%>">
                            </div>
                        </div>
                    </div>
                    <div class="col-4 offset-8 mt-3">
                        <button type="submit" class="btn btn-warning bg">Xác nhận</button>
                        <button type="reset" class="btn btn-warning bg">Làm lại</button>
                    </div>
                    
                    
                </form>
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
        <%
        };
        %>
        <script src="js/JQuery-3.7.0.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/main.js"></script>
        <script type="text/javascript">
        if($("#mess").val() == "1"){
        	alert("Lỗi trùng khóa, vui lòng thử lại hoặc liên hệ hỗ trợ");
        } else if ($("#mess").val()  == "2") {
        	alert ("Hãy điền đẩy đủ các mục yêu cầu");
        } else if ($("#mess").val()  == "3") {
        	alert ("Đơn giá không đúng, đơn giá phải là số");
        } else if ($("#mess").val()  == "4") {
        	alert ("Số lượng không đúng, số lượng phải là số");
        } else if ($("#mess").val()  == "5") {
        	alert ("Lỗi không xác định vui lòng liên hệ hỗ trợ");
        }
        </script>

    </body>
</html>