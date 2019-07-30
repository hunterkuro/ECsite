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
<title>MyPage画面</title>

</head>
<body>
	<div id="header">
		<div id="pr">
		</div>
	</div>
	<div id ="main">
		<div id="top">


			<p>MyPage</p>
		</div>
		<div>

<%-- MyPageActionからgetterでmyPageListの値を参照。
	 myPageList == null (データ削除されている場合。購入がされてない場合)ifを実行して63行目まで飛ぶ --%>
		<s:if test="myPageList == null">
			<h3>購入情報はありません。</h3>
		</s:if>

<%-- messageは履歴String削除を行った際MyPageActionで値が入る null ということは削除が行われていない際 --%>
		<s:elseif test="message == null">
			<h3>購入情報は以下になります。</h3>
			<table border="1">
			<tr>
				<th>商品名</th>
				<th>値段</th>
				<th>購入個数</th>
				<th>支払い方法</th>
				<th>購入日</th>
			</tr>

<%--Iteratorインタフェースは、ListやMapなどのコレクションの要素を、順番に処理する場合に使用する。 --%>
			<s:iterator value="myPageList">
				<tr>
					<td><s:property value="itemName"/></td>
					<td><s:property value="totalPrice"/><span>円</span></td>
					<td><s:property value="totalCount"/><span>個</span></td>
					<td><s:property value="payment"/></td>
					<td><s:property value="insert_date"/></td>
				</tr>
			</s:iterator>
			</table>

<%-- 削除ボタンを押すとhidden(表示されない入力)でdeleteFlgに1を入れてMyPageActionに送る。 --%>
			<s:form action ="MyPageAction">
				<input type = "hidden" name="deleteFlg" value="1">
				<s:submit value="削除"/>
			</s:form>
		</s:elseif>

<%-- message != null(1度以上の削除が行われて 合否のメッセージが格納されている場合) メッセージの表示 --%>
		<s:if test="message != null">
		 <h3><s:property value="message"/></h3>
		 </s:if>

			<div id="text-right">

<%-- sessionを保持してhome.jspへ --%>
				<p>Home画面に戻る場合は
				<a href='<s:url action="GoHomeAction"/>'>こちら</a></p>

<%-- sessionをクリアしてhome.jspへ --%>
				<p>ログアウトする場合は
				<a href='<s:url action="LogoutAction"/>'>こちら</a></p>
			</div>
		</div>
	</div>
	<div id="footer">
		<div id="pr">
		</div>
	</div>
</body>
</html>