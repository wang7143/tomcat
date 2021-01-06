<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div id="page_nav">
    <c:if test="${requestScope.page.pageNum > 1}">
        <a href="${ requestScope.page.url }&pageNo=1">首页</a>
        <a href="${ requestScope.page.url }&pageNo=${requestScope.page.pageNum - 1}">上一页</a>
    </c:if>
    
    <c:choose>
        <c:when test="${ requestScope.page.pageTotal <= 5}">
            <c:set var="begin" value="1"/>
            <c:set var="end" value="${requestScope.page.pageTotal}"/>
        </c:when>
        <c:when test="${requestScope.page.pageTotal > 5}">
            <c:choose>
                <c:when test="${requestScope.page.pageNum <= 3}">
                    <c:set var="begin" value="1"/>
                    <c:set var="end" value="5"/>
                </c:when>
                <c:when test="${requestScope.page.pageNum > requestScope.page.pageTotal - 3}">
                    <c:set var="begin" value="${requestScope.page.pageTotal - 4}"/>
                    <c:set var="end" value="${requestScope.page.pageTotal}"/>
                </c:when>
                <c:otherwise>
                    <c:set var="begin" value="${requestScope.page.pageTotal - 2}"/>
                    <c:set var="end" value="${requestScope.page.pageNum + 2}"/>
                    
                </c:otherwise>
            </c:choose>
        </c:when>	
    </c:choose>
        <c:forEach begin="${begin}" end="${end}" var = "i">
            <c:if test="${i==requestScope.page.pageNum}">
                【${i}】
            </c:if>
            
            <c:if test="${i != requestScope.page.pageNum}">
                <a href="${ requestScope.page.url }&pageNo=${i}">${i}</a>
            </c:if>
        </c:forEach>

    <%-- 【${ requestScope.page.pageNum }】 --%>
    <%-- <a href="#">5</a> --%>
    <c:if test="${requestScope.page.pageNum < requestScope.page.pageTotal}">
        <a href="${ requestScope.page.url }&pageNo=${requestScope.page.pageNum + 1}">下一页</a>
        <a href="${ requestScope.page.url }&pageNo=${requestScope.page.pageTotal}">末页</a>
    </c:if>
    
    共${requestScope.page.pageTotal}页，${requestScope.page.pageTotalCount}条记录 
    到第<input value="${param.pageNo}" name="pn" id="pn_input"/>页
    <input id="searchPage" type="button" value="确定">
    <script type="text/javascript">
        $(function(){
            $("#searchPage").click(function(){
                var pageNo = $("#pn_input").val();
                // var pageTotal = ${requestScope.page.pageTotal};
                
                alert(location.href = "${pageScope.basePath}${ requestScope.page.url }&pageNo=" + pageNo);
            })
        })
    </script>
</div>