package utwente.groep18.databaseEntries;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

//Will map the resource to the URL ideas
@Path("/ideas")
public class IdeaResources {

	// Allows to insert contextual objects into the class, 
	// e.g. ServletContext, Request, Response, UriInfo
	@Context
	UriInfo uriInfo;
	@Context
	Request request;


	// Return the list of ideas to the user in the browser
	@GET
	@Produces(MediaType.TEXT_XML)
	public List<Idea> getIdeasBrowser() {
		List<Idea> ideas = new ArrayList<Idea>();
		ideas.addAll(IdeaDao.instance.getModel().values());
		return ideas; 
	}
	
	// Return the list of ideas to the user in the browser with limit
		@GET
		@Produces(MediaType.TEXT_XML)
		public List<Idea> getIdeasBrowser(int limit) {
			List<Idea> ideas = new ArrayList<Idea>();
			int length = IdeaDao.instance.getModel().size();
			if (length <= limit)
				ideas.addAll(IdeaDao.instance.getModel().values());
			else {
				for(int i = 0; i < limit; i++) {
					int id = (int) IdeaDao.instance.getModel().keySet().toArray()[i];
					ideas.add(IdeaDao.instance.getModel().get(id));
				}
			}
			return ideas; 
		}

	// Return the list of ideas for applications
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<Idea> getIdeas() {
		List<Idea> ideas = new ArrayList<Idea>();
		ideas.addAll(IdeaDao.instance.getModel().values());
		return ideas;
	}
	
	// Return the list of ideas for applications with limit
		@GET
		@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
		public List<Idea> getIdeas(int limit) {
			List<Idea> ideas = new ArrayList<Idea>();
			int length = ideas.size();
			if (length <= limit)
				ideas.addAll(IdeaDao.instance.getModel().values());
			else {
				for (int i = 0; i < limit; i++) {
					int id = (int) IdeaDao.instance.getModel().keySet().toArray()[i];
					ideas.add(IdeaDao.instance.getModel().get(id));
				}
			}
			return ideas;
		}


	// retuns the number of ideas
	// use http://localhost:8080/ThinkTankWeb/rest/ideas/count
	// to get the total number of records
	@GET
	@Path("count")
	@Produces(MediaType.TEXT_PLAIN)
	public String getCount() {
		int count = IdeaDao.instance.getModel().size();
		return String.valueOf(count);
	}

	@POST
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void newIdea(@FormParam("id") Integer id,
			@FormParam("summary") String summary,
			@FormParam("description") String description,
			@Context HttpServletResponse servletResponse) throws IOException {
		//TODO
		//Idea idea = new Idea(id,summary);
		//IdeaDao.instance.getModel().put(id, idea);

		servletResponse.sendRedirect("../index.jsp");
	}


	// Defines that the next path parameter after ideas is
	// treated as a parameter and passed to the IdeaResources
	// Allows to type http://localhost:8080/ThinkTank/rest/ideas/1
	// 1 will be treaded as parameter idea and passed to IdeaResource
	@Path("{idea}")
	public IdeaResource getIdea(@PathParam("idea") String id) {
		return new IdeaResource(uriInfo, request, id);
	}

}
