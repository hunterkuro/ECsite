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
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
	<link rel = "stylesheet" type="text/css" href="./css/style.css">
	<title>buyItemConfirm画面</title>

<%-- ボタンごとにsubmit先のURLを変更するjQuery
	→同じformタグの中で別々のactionを設定する--%>
	<script type="text/javascript">

<%-- submitAction(url)が実行された際--%>
		function submitAction(url){

<%-- 【対象要素.attr( 属性,（変更する値）)】→form要素のaction属性のurlを変更する--%>
			$('form').attr('action',url);

<%-- 変更したformの属性をsubmitする。--%>
			$('form').submit();
		}
	</script>

	</head>
	<body>
		<div id="header">
			<div id="pr">
			</div>
		</div>
		<div id ="main">
			<div id="top">


				<p>BuyItem</p>
			</div>
			<div>
				<s:form>
						<tr>
							<td><span>商品名</span></td>
<%-- propertyで呼び出し元クラスUserCreateConfirmActionのフィールド変数をgetして表示 --%>
							<td><s:property value="session.buyItem_name"/></td>
						</tr>
						<tr>
							<td><span>値段</span></td>
							<td><s:property value="session.total_price"/>
							<span>円</span>
							</td>
						</tr>
						<tr>
							<td>購入個数</td>
							<td><s:property value="session.count"/>
							<span>個</span>
							</td>
						</tr>
						<tr>
							<td>支払い方法</td>
							<td><s:property value="session.pay"/></td>
						</tr>
						<tr>
							<td><br></td>
						</tr>
						<tr>
<%-- クリックするボタンによってjQueryでaction属性を変更する --%>
							<td><input type="button" value="戻る" onclick="submitAction('HomeAction')"/></td>
							<td><input type="button" value="完了" onclick="submitAction('BuyItemConfirmAction')"/></td>
						</tr>
				</s:form>
			</div>
				<div>
					<p>前画面に戻る場合は
					<a href='<s:url action="GoHomeAction"/>'>こちら</a></p>
					<p>マイページは
					<a href='<s:url action="MyPageAction"/>'>こちら</a></p>
				</div>
		</div>
		<div id="footer">
			<div id="pr">
			</div>
		</div>
	</body>
	</html>