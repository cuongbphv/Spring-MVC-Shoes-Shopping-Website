<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.mvp.model.*"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	 				<table class="table table-bordered col-md-12" style="text-align: center;">
                            <thead>
                                <tr>
                                    <th>Mã khuyến mãi</th>
                                    <th>Tên khuyến mãi</th>
                                    <th>Phần trăm</th>
                                    <th>Thời gian bắt đầu</th>
                                    <th>Thời gian kết thúc</th>
                                    <th>Chỉnh sửa</th>
                                    <th>Xóa</th>
                                </tr>
                            </thead>
                            <tbody>
	                            <c:forEach items="${list}" var="item">
								    <tr>
	                                    <td>${item.iD}</td>
	                                    <td>${item.name}</td>
	                                    <td>${item.percent}</td>
	                                    <td><fmt:formatDate value="${item.startTime}" pattern="dd-MM-yyyy" /></td>
	                                    <td><fmt:formatDate value="${item.endTime}" pattern="dd-MM-yyyy" /></td>
	                                    <td><button class="btn btn-primary button-style editPromotion">Chỉnh sửa</button></td>
	                                    <td><button class="btn btn-danger button-style deletePromotion">Xóa</button></td>
	                               </tr>
								</c:forEach>
                            </tbody>
                        </table>
</body>
</html>