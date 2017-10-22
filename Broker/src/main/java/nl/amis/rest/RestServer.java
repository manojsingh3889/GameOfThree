package nl.amis.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.takeaway.broker.services.DisplayGamesService;
import com.takeaway.broker.services.JoinGameService;
import com.takeaway.broker.services.NewGameService;
import com.takeaway.broker.services.RemoveGameService;
import com.takeaway.requestbean.DisplayRequest;
import com.takeaway.requestbean.JoinGameRequest;
import com.takeaway.requestbean.NewGameRequest;
import com.takeaway.requestbean.RemoveGameRequest;
import com.takeaway.responsebean.DisplayResponse;
import com.takeaway.responsebean.JoinGameResponse;
import com.takeaway.responsebean.NewGameResponse;
import com.takeaway.responsebean.RemoveGameResponse;

@Path("/broker/service")
public class RestServer {
	
	@GET
	@Path("ping")
	@Produces(MediaType.TEXT_PLAIN)
	public String ping() {
		return "LIVE";
	}
	
	@POST
	@Path("newgame")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public NewGameResponse newGame(NewGameRequest request) {
		NewGameService newGameService = new NewGameService();
		return newGameService.execute(request);
	}
	
	@POST
	@Path("displaygames")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public DisplayResponse newGame(DisplayRequest request) {
		DisplayGamesService displayGamesService = new DisplayGamesService();
		return displayGamesService.execute(request);
	}
	
	@POST
	@Path("joingame")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public JoinGameResponse joinGame(JoinGameRequest request) {
		JoinGameService joinGameService = new JoinGameService();
		return joinGameService.execute(request);
	}
	
	@POST
	@Path("removegame")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public RemoveGameResponse removeGame(RemoveGameRequest request) {
		RemoveGameService removeGameService = new RemoveGameService();
		return removeGameService.execute(request);
	}
}