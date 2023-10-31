<%@page import="common.Process"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.Product"%>
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
	<%
	int currentPageNumber = (Integer) request.getAttribute("pageNumber"); // Do server trả về
	int totalPageNumber = (Integer) request.getAttribute("totalPageNumber"); // Do server trả về

	int[] pageNumberList = new int[10]; // Do client tự tính toán
	int pageQuanlity = 0; // Do client tự tính toán
	// Tình huống số 1:

	if (totalPageNumber <= 10) {
		for (int j = 0; j < totalPageNumber; j++) {
			pageNumberList[j] = j + 1;
			pageQuanlity++;
		}
	}
	// Tình huống số 3:

	if (totalPageNumber > 10 && currentPageNumber <= 4) {
		for (int j = 0; j < 10; j++) {
			pageNumberList[j] = j + 1;
			pageQuanlity++;
		}
	}

	// Tình huống số 4:

	if (totalPageNumber > 10 && currentPageNumber >= (totalPageNumber - 5)) {
		for (int j = 10; j >= 1; j--) {
			pageNumberList[j - 1] = totalPageNumber - (10 - j);
			pageQuanlity++;
		}
	}

	// Tình huống số 5:

	if (totalPageNumber > 10 && currentPageNumber >= 5 && currentPageNumber <= (totalPageNumber - 5)) {
		for (int j = 0; j < 10; j++) {
			pageNumberList[j] = currentPageNumber - 3 + j;
			pageQuanlity++;
		}
	}
	%>
	<div class="row">
		<div class="col-3 offset-9 mt-3">
			<button type="button" onclick="location.href='addProduct.jsp'"
				class="btn btn-warning">Thêm hàng hóa</button>
		</div>
	</div>
	<div class="container mt-5 ">
		<h1 class="text-center m-3">Seller</h1>

		<div class="row">
			<%
			ArrayList<Product> p = (ArrayList<Product>) request.getAttribute("list");

			for (Product dp : p) {
			%>
			<div class="col-3 mb-3">
				<div class="card text-center" style="width: 18rem;">
					<img src="<%=dp.getHinhAnh()%>" width="280px" height="280px"
						class="card-img-top" alt="Lỗi"><br>
					<div class="card-body">
						<h3 class="card-title"><%=dp.getTenSP()%></h3>
						<p><%=Process.convertDoubleToStringWithComma(dp.getDonGia())%>$
						</p>
						<p>
							Số lượng:
							<%=Process.convertDoubleToStringWithComma(dp.getSoLuong())%>/<%=dp.getDonViTinh()%></p>
						<br>
						<button type="button" onclick="modify('<%=dp.getMaSP()%>');"
							class="btn btn-warning bg">Sửa hàng</button>
						<button type="button" onclick="del('<%=dp.getMaSP()%>');"
							class="btn btn-warning bg">Xóa hàng</button>
					</div>
				</div>
			</div>
			<%
			} ;
			%>

		</div>
		<div class="row">
			<div class="col-3">
				<p>
					Đang ở trang
					<%=currentPageNumber%>
					trên tổng số
					<%=totalPageNumber%>
					trang
				</p>
			</div>
			<div class="col-6 offset-3">
				<div class="btn-toolbar mb-3" role="toolbar"
					aria-label="Toolbar with button groups">
					<div class="btn-group me-2" role="group" aria-label="First group">
						<%
						if (currentPageNumber > 1) {
						%>
						<button onclick="tranPage('1');" type="button"
							class="btn btn-warning bg">First page</button>
						<button onclick="tranPage('<%=currentPageNumber - 1%>');"
							type="button" class="btn btn-warning bg">Previous Page</button>
						<%
						} ;

						for (int k = 0; k < pageQuanlity; k++) {
						if (currentPageNumber == pageNumberList[k]) {
						%>
						<button onclick="tranPage('<%=pageNumberList[k]%>');"
							type="button" class="btn btn-outline-warning active"><%=pageNumberList[k]%></button>
						<%
						} else {
						%>
						<button onclick="tranPage('<%=pageNumberList[k]%>');"
							type="button" class="btn btn-outline-warning"><%=pageNumberList[k]%></button>
						<%
						}
						} ;
						if (currentPageNumber < totalPageNumber) {
						%>
						<button onclick="tranPage('<%=currentPageNumber + 1%>');"
							type="button" class="btn btn-warning bg">Next page</button>
						<button onclick="tranPage('<%=totalPageNumber%>');" type="button"
							class="btn btn-warning bg">Last Page</button>
						<%
						} ;
						%>
					</div>
				</div>
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
					<a class="git" href="#"><i class="bi bi-github"></i> GITHUB</a>
				</div>
				<div class="col-1">
					<a class="twi" href="#"><i class="bi bi-twitter"></i> TWITTER</a>
				</div>
			</div>
		</div>
	</footer>
	<%
	}
	%>
	<script src="js/JQuery-3.7.0.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/main.js"></script>
	<script type="text/javascript">
		if ("1" == $('#mess').val()) {
			alert("Đã xóa sản phẩm thành công!")
		} else if ("2"== $('#mess').val()){
			alert ("Đã thêm sản phẩm thành công!")
		} else if ("3"== $('#mess').val()){
			alert ("Đã sửa sản phẩm thành công!")
		}
		function tranPage(page) {
			location.href = 'ShowProductListServlet?page=' + page;
		};
		function modify(MaSP) {
			location.href = 'ShowModifyProductServlet?MaSP=' + MaSP;
		};
		function del(MaSP) {
			if (confirm("Bạn có muốn xóa không?")) {
				location.href = 'DeleteProductServlet?MaSP=' + MaSP;
			}
		};
	</script>

</body>
</html>