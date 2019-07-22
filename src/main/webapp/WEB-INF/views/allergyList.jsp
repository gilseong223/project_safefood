<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="edu.ssafy.root.member.Member"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% Member mem = ((Member)request.getAttribute("member")); %>
<% String[] type = {"bean 0", "penut 1", "milk 2", "crab 3", "shrimp 4", "tuna 5", "salmon 6", "mugwort 7", "beaf 8", "chicken 9", "pork 10", "peach 11", "dandelion 12", "egg 13"}; %>
<% String[] typeKor = {"대두","땅콩","우유","게","새우","참치","연어","쑥","소고기","닭고기","돼지고기","복숭아","민들레","계란흰자"}; %>

<div class="custom-check">
	<% for(int i=0; i<14; i++){ %>

		<label class="mx-4">
			<c:choose>
				<c:when test="<%= mem.getAllergy().checkAllergy(i+1) == true %>">
					<input type="checkbox" value="<%= type[i] %>" name="allergy" checked="checked"> <%=typeKor[i] %>
				</c:when>
				<c:otherwise>
					<input type="checkbox" value="<%= type[i] %>" name="allergy"> <%=typeKor[i] %>
				</c:otherwise>
			</c:choose>
		</label>
	<% } %>
</div>
