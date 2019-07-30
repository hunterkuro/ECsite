	<%@ page language="java" contentType="text/html; charset=UTF-8"
	    pageEncoding="UTF-8"%>
	   <%@ taglib prefix="s" uri="/struts-tags" %>
	<!DOCTYPE html>
	<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta http-equiv="Content-Style-Type" content="text/css"/>
	<meta http-equiv="Content-Script-Type" content="text/javascript"/>
	<meta http-equiv="imagetoolbar" content="no"/>
	<meta name="description" content=""/>
	<meta name="keywords" content=""/>

	<link rel = "stylesheet" type="text/css" href="./css/style.css">
	<title>UserCreateConfirm画面</title>
	</head>
	<body>
		<div id="header">
			<div id="pr">
			</div>
		</div>
		<div id ="main">
			<div id="top">


				<p>UserCreateConfirm</p>
			</div>
			<div>
				<h3>登録する内容は以下でよろしいですか。</h3>
<%-- <table>内に<tr>で表の横一行を定義して、<th>(見出し)<td>(データ)を定義していく。 --%>
				<table>
				<s:form action="UserCreateCompleteAction">
					<tr id ="box">
						<td><label>ログインID:</label></td>
						<td><s:property value="loginUserId" escape="false"/></td>
					</tr>
					<tr id ="box">
						<td><label>ログインPASS:</label></td>
						<td><s:property value="loginPassword" escape="false"/></td>
					</tr>
					<tr id ="box">
						<td><label>ユーザー名:</label></td>
						<td><s:property value="userName" escape="false"/></td>
					</tr>
					<tr>

<%--ボタンでUserCreateCompleteActionに移行 --%>
						<td><s:submit value="完了"/></td>
					</tr>
				</s:form>
				</table>
			</div>
		</div>
		<div id="footer">
			<div id="pr">
			</div>
		</div>
	</body>
	</html>