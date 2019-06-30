<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<h1>Contact page</h1>


<table class="table ashboard-task-infos">
                                    <thead>
                                        <tr>
                                            <th>Contact Id</th>
                                            <th>First Name</th>
                                            <th>Last Name</th>
                                            <th>Contact 1</th>
                                            <th>Contact 2</th>
											<th>Group</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                      <c:forEach items="${contacts}" var="contact">
                                      	 <tr>
										    <td><c:out value="${contact.contactId}" /></td>
                                            <td><c:out value="${contact.firstName}" /></td>
											<td><c:out value="${contact.lastName}" /></td>
                                            <td><c:out value="${contact.contactNo1}" /></td>
                                            <td><c:out value="${contact.contactNo2}" /></td>
											 <td><c:out value="${contact.groupId}" /></td>
                                        </tr>
                                        </c:forEach>
                                     
                                    </tbody>
                                </table>