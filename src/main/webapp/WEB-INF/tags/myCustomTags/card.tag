<%@ tag body-content="empty" %>
<%@ attribute name="name" required="true" type="java.lang.String" %>
<%@ attribute name="familyName" required="false" type="java.lang.String" %>
<%@ attribute name="email" required="true" type="java.lang.String" %>
<%@ attribute name="photo" required="true" type="java.lang.String" %>

<div class="example-2 card">
    <div class="wrapper" style="background: url('${photo}') no-repeat">
        <div class="header">
            <!--div class="date">
                <span class="day">12</span>
                <span class="month">Aug</span>
                <span class="year">2016</span>
            </div-->
            <ul class="menu-content">
                <li>
                    <a href="#" class="fa fa-bookmark-o"></a>
                </li>
                <li><a href="#" class="fa fa-heart-o"><span>18</span></a></li>
                <li><a href="#" class="fa fa-comment-o"><span>3</span></a></li>
            </ul>
        </div>

        <div class="data">
            <div class="content">
                <span class="author"></span>
                <h1 class="title"><a href="#">${name} ${familyName}</a></h1>
                <p class="text"></p>
                <input type="hidden"  id="id" name="id" value="${email}"/>
                <a href="#" class="button" onclick="processUser(this,'/edit');">Edit</a>
                <a href="#" class="button" onclick="processUser(this,'/remove');">Remove</a>
            </div>
        </div>
    </div>
</div>