<%@ page import="com.el.Person" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
    <%
        Person person = new Person();
        person.setName("123");
        person.setPhones(new String[]{"1351351","11515151"});

        List<String> cities = new ArrayList<String>();
        cities.add("beijing");
        cities.add("shanghai");
        person.setCities(cities);

        Map<String,Object>map = new HashMap<>();
        map.put("key1","value1");
        map.put("key2","value2");
        person.setMap(map);

        pageContext.setAttribute("p",person);
    %>

    输出Person：${p}<br/>
    out name: ${p.name}<br/>
</body>
</html>