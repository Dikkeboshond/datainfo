package utwente.groep18.databaseEntries;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;

public class IdeaResource {
  @Context
  UriInfo uriInfo;
  @Context
  Request request;
  String id;
  public IdeaResource(UriInfo uriInfo, Request request, String id) {
    this.uriInfo = uriInfo;
    this.request = request;
    this.id = id;
  }
  
  //Application integration     
  @GET
  @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
  public Idea getIdea() {
	  Idea idea = IdeaDao.instance.getModel().get(id);
    if(idea==null)
      throw new RuntimeException("Get: Idea with " + id +  " not found");
    return idea;
  }
  
  // for the browser
  @GET
  @Produces(MediaType.TEXT_XML)
  public Idea getIdeaHTML() {
	  Idea todo = IdeaDao.instance.getModel().get(id);
    if(todo==null)
      throw new RuntimeException("Get: Idea with " + id +  " not found");
    return todo;
  }
  
  @PUT
  @Consumes(MediaType.APPLICATION_XML)
  public Response putIdea(JAXBElement<Idea> idea) {
	  Idea c = idea.getValue();
    return putAndGetResponse(c);
  }
  
  @DELETE
  public void deleteIdea() {
	  Idea c = IdeaDao.instance.getModel().remove(id);
    if(c==null)
      throw new RuntimeException("Delete: Idea with " + id +  " not found");
  }
  
  private Response putAndGetResponse(Idea idea) {
    Response res;
    if(IdeaDao.instance.getModel().containsKey(idea.getId())) {
      res = Response.noContent().build();
    } else {
      res = Response.created(uriInfo.getAbsolutePath()).build();
    }
    IdeaDao.instance.getModel().put(idea.getId(), idea);
    return res;
  }
} 