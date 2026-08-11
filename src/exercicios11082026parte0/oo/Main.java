package exercicios11082026parte0.oo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Main {

	public static void main(String[] args) {

		Developer developer = new Developer(1L, "Alice Developer", "alice@studio.com", "Alpha Games", "Brazil");

		Publisher publisher = new Publisher(1L, "Global Games Publishing", "United States");

		Player player = new Player(1L, "Loester", "loester@email.com", "loesterdev", 15);

		Game game = new Game(1L, "Cyber World", "Open world action RPG", new BigDecimal("149.90"), Genre.RPG, Platform.PC, GameStatus.AVAILABLE, developer, publisher);

		developer.addGame(game);
		publisher.addGame(game);
		player.addGame(game);

		Achievement achievement = new Achievement(1L, "First Mission", "Complete your first mission", 100, game);

		game.addAchievement(achievement);
		player.addAchievement(achievement);

		Review review = new Review(1L, player, game, 5, "Excellent game");

		game.addReview(review);

		GameSession session = new GameSession(1L, player, game, LocalDateTime.now(), LocalDateTime.now().plusHours(2), 2500);

		Purchase purchase = new Purchase(1L, player, game, game.getPrice(), LocalDateTime.now(), PurchaseStatus.COMPLETED);

		Wishlist wishlist = new Wishlist(1L, player);

		wishlist.addGame(game);

		GameLibrary<Game> library = new GameLibrary<>(1L, player);

		library.addGame(game);

		GameStore<Game> store = new GameStore<>(1L, "Game Store", "Brazil");

		store.addGame(game);

		System.out.println(developer);
		
		System.out.println();
		System.out.println(publisher);
		
		System.out.println();
		System.out.println(player);
		
		System.out.println();
		System.out.println(game);
		
		System.out.println();
		System.out.println(achievement);
		
		System.out.println();
		System.out.println(review);
		
		System.out.println();
		System.out.println(session);
		
		System.out.println();
		System.out.println(purchase);
		
		System.out.println();
		System.out.println(wishlist);
		
		System.out.println();
		System.out.println(library);
		
		System.out.println();
		System.out.println(store);
		
		
		System.out.println();
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Find game by ID:");
		library.findById(1L).ifPresent(System.out::println);

		System.out.println();

		System.out.println("Find games by genre:");
		store.findByGenre(Genre.RPG).forEach(System.out::println);

		System.out.println();

		System.out.println("Available games:");
		store.findAvailableGames().forEach(System.out::println);

		
		
		System.out.println();
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("TOSTRING");
		System.out.println(developer.toString());
		System.out.println(publisher.toString());
		System.out.println(player.toString());
		System.out.println(game.toString());
		System.out.println(achievement.toString());
		System.out.println(review.toString());
		System.out.println(session.toString());
		System.out.println(purchase.toString());
		System.out.println(wishlist.toString());
		System.out.println(library.toString());
		System.out.println(store.toString());

		
		
		System.out.println();
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("SYSOUT OBJECTS");

		System.out.println(developer);
		System.out.println(publisher);
		System.out.println(player);
		System.out.println(game);
		System.out.println(achievement);
		System.out.println(review);
		System.out.println(session);
		System.out.println(purchase);
		System.out.println(wishlist);
		System.out.println(library);
		System.out.println(store);

		

		System.out.println();
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("INSTANCEOF");

		System.out.println();
		System.out.println("developer instanceof Developer: " + (developer instanceof Developer));
		System.out.println("developer instanceof Person: " + (developer instanceof Person));
		System.out.println("developer instanceof Identifiable: " + (developer instanceof Identifiable));
		System.out.println("developer instanceof Object: " + (developer instanceof Object));

		System.out.println();
		System.out.println("player instanceof Player: " + (player instanceof Player));
		System.out.println("player instanceof Person: " + (player instanceof Person));
		System.out.println("player instanceof Identifiable: " + (player instanceof Identifiable));
		System.out.println("player instanceof Object: " + (player instanceof Object));

		System.out.println();
		System.out.println("publisher instanceof Publisher: " + (publisher instanceof Publisher));
		System.out.println("publisher instanceof Identifiable: " + (publisher instanceof Identifiable));
		System.out.println("publisher instanceof Object: " + (publisher instanceof Object));

		System.out.println();
		System.out.println("game instanceof Game: " + (game instanceof Game));
		System.out.println("game instanceof Identifiable: " + (game instanceof Identifiable));
		System.out.println("game instanceof Object: " + (game instanceof Object));

		System.out.println();
		System.out.println("achievement instanceof Achievement: " + (achievement instanceof Achievement));
		System.out.println("achievement instanceof Identifiable: " + (achievement instanceof Identifiable));
		System.out.println("achievement instanceof Object: " + (achievement instanceof Object));

		System.out.println();
		System.out.println("review instanceof Review: " + (review instanceof Review));
		System.out.println("review instanceof Identifiable: " + (review instanceof Identifiable));
		System.out.println("review instanceof Object: " + (review instanceof Object));

		System.out.println();
		System.out.println("session instanceof GameSession: " + (session instanceof GameSession));
		System.out.println("session instanceof Identifiable: " + (session instanceof Identifiable));
		System.out.println("session instanceof Object: " + (session instanceof Object));

		System.out.println();
		System.out.println("purchase instanceof Purchase: " + (purchase instanceof Purchase));
		System.out.println("purchase instanceof Identifiable: " + (purchase instanceof Identifiable));
		System.out.println("purchase instanceof Object: " + (purchase instanceof Object));

		System.out.println();
		System.out.println("wishlist instanceof Wishlist: " + (wishlist instanceof Wishlist));
		System.out.println("wishlist instanceof Identifiable: " + (wishlist instanceof Identifiable));
		System.out.println("wishlist instanceof Object: " + (wishlist instanceof Object));

		System.out.println();
		System.out.println("library instanceof GameLibrary: " + (library instanceof GameLibrary));
		System.out.println("library instanceof Object: " + (library instanceof Object));

		System.out.println();
		System.out.println("store instanceof GameStore: " + (store instanceof GameStore));
		System.out.println("store instanceof Identifiable: " + (store instanceof Identifiable));
		System.out.println("store instanceof Object: " + (store instanceof Object));

		
		
		System.out.println();
		System.out.println("--------------------------------------------------------------------------------");		
		System.out.println("POLYMORPHISM");

		Person person1 = developer;
		Person person2 = player;

		System.out.println("person1: " + person1);
		System.out.println("person2: " + person2);

		System.out.println();
		System.out.println("person1 instanceof Developer: " + (person1 instanceof Developer));
		System.out.println("person1 instanceof Player: " + (person1 instanceof Player));
		System.out.println("person1 instanceof Person: " + (person1 instanceof Person));

		System.out.println();
		System.out.println("person2 instanceof Developer: " + (person2 instanceof Developer));
		System.out.println("person2 instanceof Player: " + (person2 instanceof Player));
		System.out.println("person2 instanceof Person: " + (person2 instanceof Person));

	
		System.out.println();
		System.out.println("--------------------------------------------------------------------------------");				
		System.out.println("IDENTIFIABLE");

		Identifiable<Long> identifiableDeveloper = developer;
		Identifiable<Long> identifiablePlayer = player;
		Identifiable<Long> identifiableGame = game;
		Identifiable<Long> identifiablePublisher = publisher;
		Identifiable<Long> identifiableReview = review;
		Identifiable<Long> identifiableAchievement = achievement;
		Identifiable<Long> identifiableSession = session;
		Identifiable<Long> identifiablePurchase = purchase;
		Identifiable<Long> identifiableWishlist = wishlist;
		Identifiable<Long> identifiableStore = store;

		System.out.println("Developer ID: " + identifiableDeveloper.getId());
		System.out.println("Player ID: " + identifiablePlayer.getId());
		System.out.println("Game ID: " + identifiableGame.getId());
		System.out.println("Publisher ID: " + identifiablePublisher.getId());
		System.out.println("Review ID: " + identifiableReview.getId());
		System.out.println("Achievement ID: " + identifiableAchievement.getId());
		System.out.println("GameSession ID: " + identifiableSession.getId());
		System.out.println("Purchase ID: " + identifiablePurchase.getId());
		System.out.println("Wishlist ID: " + identifiableWishlist.getId());
		System.out.println("GameStore ID: " + identifiableStore.getId());

		
		System.out.println();
		System.out.println("--------------------------------------------------------------------------------");	
		System.out.println("GENERICS");
		System.out.println("Library class: " + library.getClass().getSimpleName());
		System.out.println("Store class: " + store.getClass().getSimpleName());
		System.out.println("Library contains games: " + library.getGames().size());
		System.out.println("Store contains games: " + store.getGames().size());

		
		System.out.println();
		System.out.println("--------------------------------------------------------------------------------");	
		System.out.println("OPTIONAL");
		library.findById(1L).ifPresent(foundGame -> System.out.println("Found: " + foundGame));
		library.findById(999L).ifPresentOrElse(foundGame -> System.out.println("Found: " + foundGame), () -> System.out.println("Game not found"));

		
		System.out.println();
		System.out.println("--------------------------------------------------------------------------------");	
		System.out.println("STREAMS");
		System.out.println("Games by RPG:");
		store.findByGenre(Genre.RPG).forEach(System.out::println);

		
		System.out.println();
		System.out.println("--------------------------------------------------------------------------------");	
		System.out.println("Available games:");
		store.findAvailableGames().forEach(System.out::println);

	}
}