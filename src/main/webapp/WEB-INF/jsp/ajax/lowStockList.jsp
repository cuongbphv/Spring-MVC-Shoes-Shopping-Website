<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
	
	                <h3 style="text-align:center;" class="col-md-9">Danh sách sản phẩm hết hàng</h3>
                    <div class="table-responsive col-md-9 ">
                        <table class="table table-bordered col-md-12 " style="text-align: center; ">
                                <thead>
                                    <tr>
                                        <th>Mã giày</th>
                                        <th>Tên giày</th>
                                        <th>Số lượng</th>
                                    </tr>
                                </thead>
                                <tbody>
                                  <c:forEach items="${list}" var="item">
	                                <tr>
	                                    <td>${item.iD }</td>
	                                    <td>${item.name}</td>
	                                    <td>${item.quantity }</td>
	                                </tr>
								</c:forEach>                        
                                </tbody>
                            </table>
                    </div>
	
</body>
</html>