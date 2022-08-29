package ro.itschool.startup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ro.itschool.entity.*;
import ro.itschool.enums.Style;
import ro.itschool.service.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Component
public class RunAtStartup {

    @Autowired
    private UserService userService;
    @Autowired
    private ArchitectureService architectureService;
    @Autowired
    private MusicService musicService;
    @Autowired
    private PaintingService paintingService;
    @Autowired
    private LiteratureService literatureService;
    @Autowired
    private SculptureService sculptureService;
    @Autowired
    private CinemaService cinemaService;
    @Autowired
    private BalletAndTheatreService balletAndTheatreService;


    @EventListener(ContextRefreshedEvent.class)
    public void contextRefreshedEvent() {

        saveAdmin();
        saveContributor();
        saveUser();

        saveArchitecture();
        saveSculpture();
        saveBalletAndTheatre();
        savePainting();
        saveMusic();
        saveLiterature();
        saveCinema();

    }

    public void saveAdmin() {
        User user = new User();
        user.setUsername("Admin");
        user.setPassword("Admin");
        user.setRandomToken("randomToken");
        final Role roleUserAdmin = new Role("ROLE_ADMIN");
        final Set<Role> roles = new HashSet<>();
        roles.add(roleUserAdmin);
        user.setRoles(roles);
        user.setEnabled(true);
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.setEmail("admin1@gmail.com");
        user.setFullName("Admin1");
        user.setPasswordConfirm("Admin");
        user.setRandomTokenEmail("randomToken");
        userService.saveUser(user);
    }

    public void saveContributor() {
        User user = new User();
        user.setUsername("Contributor");
        user.setPassword("Contributor");
        user.setRandomToken("randomToken");
        final Set<Role> roleUserContributor = new HashSet<>();
        roleUserContributor.add(new Role("ROLE_CONTRIBUTOR"));
        user.setRoles(roleUserContributor);
        user.setEnabled(true);
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.setEmail("contributor1@gmail.com");
        user.setFullName("Contributor1");
        user.setPasswordConfirm("Contributor");
        user.setRandomTokenEmail("randomToken");
        userService.saveUser(user);
    }

    public void saveUser() {
        User user = new User();
        user.setUsername("User");
        user.setPassword("User");
        user.setRandomToken("randomToken");
        final Set<Role> roleUserUser = new HashSet<>();
        roleUserUser.add(new Role("ROLE_USER"));
        user.setRoles(roleUserUser);
        user.setEnabled(true);
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.setEmail("user1@gmail.com");
        user.setFullName("User");
        user.setPasswordConfirm("User");
        user.setRandomTokenEmail("randomToken");
        userService.saveUser(user);
    }

    public void saveArchitecture() {
        Set<Architecture> architectures = new HashSet<>();
        Architecture architecture = new Architecture();
        architecture.setName("Chateau de Chambord");
        architecture.setImageLink("https://royal-connection.fr/wp-content/uploads/2017/05/excursion-chateau-chambord.jpg");
        architecture.setMovement(Style.RENAISSANCE);
        architecture.setLocation("Chateau, 41250, Chambord, France");
        architecture.setAuthor("Domenico da Cortona");
        architecture.setYear(1547);
        architecture.setIsTemporary(false);

        Architecture architecture2 = new Architecture();
        architecture2.setName("Notre-Dame de Paris");
        architecture2.setImageLink("https://www.piatraonline.ro/userfiles/19370a59-92cf-454a-b230-f7886006c901/Image/2_v120.jpg");
        architecture2.setMovement(Style.GOTHIC);
        architecture2.setLocation("Parvis Notre-Dame, 75004, Paris, France");
        architecture2.setAuthor("Jean de Chelles");
        architecture2.setYear(1345);
        architecture2.setIsTemporary(false);

        Architecture architecture3 = new Architecture();
        architecture3.setName("Casa Batllo");
        architecture3.setImageLink("https://www.artmajeur.com/medias/hd/r/a/radu-bercan/artwork/13405976_dsc05184af.jpg");
        architecture3.setMovement(Style.ARTNOUVEAU);
        architecture3.setLocation("Pg. de Gracia, 43, 08007, Barcelona, Spania");
        architecture3.setAuthor("Antoni Gaudí");
        architecture3.setYear(1912);
        architecture3.setIsTemporary(false);

        Architecture architecture4 = new Architecture();
        architecture4.setName("Palacio da Pena)");
        architecture4.setImageLink("https://royal-connection.fr/wp-content/uploads/2017/05/excursion-chateau-chambord.jpg");
        architecture4.setMovement(Style.ROMANTICISM);
        architecture4.setLocation("Estrada da Pena, 2710, Sintra, Portugal");
        architecture4.setAuthor("Wilhelm Ludwig von Eschwege, Nicolau Pires");
        architecture4.setYear(1854);
        architecture4.setIsTemporary(false);

        architectureService.save(architecture);
        architectureService.save(architecture2);
        architectureService.save(architecture3);
        architectureService.save(architecture4);
        architectures.add(architecture);
        architectures.add(architecture2);
        architectures.add(architecture3);
        architectures.add(architecture4);
    }

    public void saveSculpture() {
        Set<Sculpture> sculptures = new HashSet<>();
        Sculpture sculpture = new Sculpture();
        sculpture.setName("The Thinker");
        sculpture.setImageLink("http://www.oceanlight.com/stock-photo/le-penseur-musee-rodin-paris-picture-28173-741166.jpg");
        sculpture.setAuthor("Auguste Rodin");
        sculpture.setLocation("77 Rue de Varenne, 75007 Paris, France");
        sculpture.setMovement(Style.REALISM);
        sculpture.setTemporary(false);
        sculpture.setYear(1902);

        Sculpture sculpture2 = new Sculpture();
        sculpture2.setName("Bird in Space");
        sculpture2.setImageLink("https://collectionapi.metmuseum.org/api/collection/v1/iiif/486757/1004909/restricted");
        sculpture2.setAuthor("Constantin Brancusi");
        sculpture2.setLocation("1000 5th Ave, New York, 10028, USA");
        sculpture2.setMovement(Style.MODERNISM);
        sculpture2.setTemporary(false);
        sculpture2.setYear(1923);

        sculptureService.save(sculpture);
        sculptureService.save(sculpture2);
        sculptures.add(sculpture);
        sculptures.add(sculpture2);
    }

    public void savePainting() {
        Set<Painting> paintings = new HashSet<>();
        Painting painting = new Painting();
        painting.setName("L'Annonciade Museum");
        painting.setImageLink("https://static.seetheworld.com/image_uploader/photos/b1/original/enjoying-art-at-musee-de-l-annonciade-saint-tropez-saint-tropez.jpg");
        painting.setMovement(Style.MODERNISM);
        painting.setLocation("Georges Grammont, 83990 Saint-Tropez, France");
        painting.setTemporary(false);
        painting.setYear(1922);

        Painting painting2 = new Painting();
        painting2.setName("Art Safari");
        painting2.setImageLink("https://www.artsafari.ro/wp-content/uploads/2022/08/cover-editia-10.png");
        painting2.setMovement(Style.CONTEMPORARY);
        painting2.setLocation("Strada Lipscani 18, București, 030167 Romania");
        painting2.setTemporary(true);
        painting2.setYear(2022);

        Painting painting3 = new Painting();
        painting3.setName("The Louvre Museum");
        painting3.setImageLink("https://res.klook.com/images/fl_lossy.progressive,q_65/c_fill,w_1295,h_720/w_80,x_15,y_15,g_south_west,l_Klook_water_br_trans_yhcmh3/activities/djvwelyhrz8z9ufftnyk/PriorityAccessEntranceTickettotheLouvreMuseum.webp");
        painting3.setMovement(Style.RENAISSANCE);
        painting3.setLocation("Rue de Rivoli, 75001 Paris, France");
        painting3.setTemporary(false);
        painting3.setYear(1793);

        paintingService.save(painting);
        paintingService.save(painting2);
        paintingService.save(painting3);
        paintings.add(painting);
        paintings.add(painting2);
        paintings.add(painting3);
    }

    public void saveMusic() {
        Set<Music> musics = new HashSet<>();
        Music music = new Music();
        music.setName("George Enescu International Festival");
        music.setImageLink("https://www.ziarulmetropolis.ro/wp-content/uploads/2020/10/slide-1.jpg");
        music.setAuthor("Orchestra Simfonică a Filarmonicii George Enescu");
        music.setMovement(Style.CONTEMPORARY);
        music.setLocation("Romanian Athenaeum, 050204, Bucharest, Romania");
        music.setTemporary(false);
        music.setEventTime(LocalDateTime.of(2022, 9, 4, 20, 0));

        Music music2 = new Music();
        music2.setName("Vienna New Year's Concert");
        music2.setImageLink("https://pbs.twimg.com/media/Ex4n24YWYAIAskV.jpg:large");
        music2.setAuthor("Hofburg Orchestra");
        music2.setMovement(Style.ROMANTICISM);
        music2.setLocation("Golden Hall of the Vienna State Opera, Austria");
        music2.setTemporary(true);
        music2.setEventTime(LocalDateTime.of(2023, 1, 1, 11, 15));
        musicService.save(music);
        musicService.save(music2);
        musics.add(music);
        musics.add(music2);
    }

    public void saveBalletAndTheatre() {
        Set<BalletAndTheatre> balletAndTheatreSet = new HashSet<>();
        BalletAndTheatre balletAndTheatre = new BalletAndTheatre();
        balletAndTheatre.setName("Swan Lake");
        balletAndTheatre.setImageLink("https://i1.sndcdn.com/artworks-000611708353-qh2fmo-t500x500.jpg");
        balletAndTheatre.setAuthor("English National Ballet");
        balletAndTheatre.setLocation("London Coliseum, St Martin's Ln, London, UK");
        balletAndTheatre.setMovement(Style.ROMANTICISM);
        balletAndTheatre.setEventTime(LocalDateTime.of(2022, 9, 28, 20, 0));
        balletAndTheatre.setTemporary(true);
        balletAndTheatreService.save(balletAndTheatre);
        balletAndTheatreSet.add(balletAndTheatre);
    }

    public void saveLiterature() {
        Set<Literature> literatures = new HashSet<>();
        Literature literature = new Literature();
        literature.setName("Livraria Lello & Irmão");
        literature.setImageLink("https://static.saltinourhair.com/wp-content/uploads/2021/05/12103516/Livraria-Lello-porto2.jpg");
        literature.setLocation("R. das Carmelitas 144, 4050-161 Porto, Portugal");
        literature.setMovement(Style.ARTNOUVEAU);
        literature.setTemporary(false);
        literature.setYear(1906);

        Literature literature2 = new Literature();
        literature2.setName("Strahov Library");
        literature2.setImageLink("https://www.pandotrip.com/wp-content/uploads/2014/06/Clementinum-National-Library.jpg");
        literature2.setLocation("Strahovské nádvoří 132/1, 118 00 Praha, Czech Republic");
        literature2.setMovement(Style.GOTHIC);
        literature2.setTemporary(false);
        literature2.setYear(1138);

        literatureService.save(literature);
        literatureService.save(literature2);
        literatures.add(literature);
        literatures.add(literature2);
    }

    public void saveCinema() {
        Set<Cinema> cinemas = new HashSet<>();
        Cinema cinema = new Cinema();
        cinema.setName("Cannes Film Festival");
        cinema.setImageLink("https://malaya.com.ph/wp-content/uploads/2020/03/Cannes.jpg");
        cinema.setLocation("Palace of Festivals and Congresses of Cannes, France");
        cinema.setMovement(Style.CONTEMPORARY);
        cinema.setEventTime(LocalDate.of(2023, 5, 16));
        cinema.setTemporary(true);

        Cinema cinema2 = new Cinema();
        cinema2.setName("The National Museum of Cinema");
        cinema.setImageLink("https://c8.alamy.com/comp/HGNBM9/tourists-visit-national-museum-of-cinema-in-turin-italy-HGNBM9.jpg");
        cinema2.setLocation("Via Montebello, 20, 10124 Torino, Italy");
        cinema2.setMovement(Style.CONTEMPORARY);
        cinema2.setEventTime(LocalDate.of(1958, 1, 1));
        cinema2.setTemporary(false);

        cinemaService.save(cinema);
        cinemaService.save(cinema2);
        cinemas.add(cinema);
        cinemas.add(cinema2);
    }
}

