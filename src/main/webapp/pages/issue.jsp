<%@ page contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>

<jsp:include page="header.jsp"/>


<div class="container-fluid">

    <c:if test="${user.role== 'Inspector'}">
        <!-- Page Heading -->
        <div class="d-sm-flex align-items-center justify-content-between mb-4">
            <h1 class="h3 mb-0 text-gray-800">Add Issue</h1>
        </div>
    </c:if>

    <!-- Content Row -->
    <div class="row">

        <c:if test="${user.role== 'Inspector'}">
            <div class="col-lg-12 m-3">
                <form class="form-horizontal" id="IssueForm">

                    <div class="card-body pb-0">

                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">Equipment</label>
                            <div class="col-sm-10">
                                <select name="equipmentId" class="form-control form-control-user">
                                    <option>- Select Equipment -</option>
                                    <c:forEach items="${equipment}" var="equipment">
                                        <option value="${equipment.id}">${equipment.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">Description</label>
                            <div class="col-sm-10">
                                        <textarea class="form-control" required rows="3" name="description"
                                                  placeholder="Enter Issue Description..."></textarea>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">Location</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" required placeholder="Enter Location..."
                                       name="location">
                            </div>
                        </div>

                        <div class="text-right">
                            <button type="submit" class="btn btn-success col-md-3">Save</button>
                            <button type="button" class="btn btn-warning col-md-3">Cancel</button>
                        </div>

                    </div>


                </form>
            </div>
        </c:if>


        <div class="col-md-12 mt-5 p-5">
            <h3 class="pb-3">Available Issues</h3>

            <table id="example1" class="table table-bordered table-hover">
                <thead>
                <tr>
                    <th>No.</th>
                    <th>Equipment</th>
                    <th>Description</th>
                    <th>Location</th>
                    <th>Inspector</th>
                        <th>Supervisor's Comment</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${issues}" var="issue" varStatus="counter">
                    <tr>
                        <td>${counter.count}</td>
                        <td>${issue.equipment.name}</td>
                        <td>${issue.description}</td>
                        <td>${issue.location}</td>
                        <td>${issue.user.firstName} ${issue.user.lastName}</td>

                            <td>
                                <form class="IssueCommentForm IssueCommentForm${issue.id}" class="input-group mb-3">
                                    <input type="hidden" name="issueId" value="${issue.id}">
                                    <input type="text" required name="comment" value="${issue.comment}"
                                        <c:if test="${user.role== 'Inspector'}">disabled</c:if>
                                           class="form-control" placeholder="Comment...">
                                    <c:if test="${user.role== 'Supervisor'}">
                                    <div class="input-group-append">
                                        <button class="btn btn-success" type="submit" value="${issue.id}">Submit</button>
                                    </div>
                                    </c:if>
                                </form>
                            </td>

                    </tr>
                </c:forEach>
                </tbody>
            </table>

        </div>

    </div>

</div>


<jsp:include page="footer.jsp"/>