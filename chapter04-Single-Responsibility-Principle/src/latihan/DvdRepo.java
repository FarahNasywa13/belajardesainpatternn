package latihan;

import java.time.LocalDate;
import java.util.*;

interface DvdRepo {
    Dvd findByDirectorIdAndDvdTitle(int directorId, String dvdTitle);

    void save(Dvd dvd);

    List<Dvd> findByDvdIds(List<Integer> dvdIds);
}

interface DirectorRepo {
    boolean checkDirectorId(int directorId);

    Director save(Director director);
}

class DvdRepository implements DvdRepo {
    private Map<Integer, Dvd> dvds = new HashMap<>();
    private static int counter = 0;

    @Override
    public Dvd findByDirectorIdAndDvdTitle(int directorId, String dvdTitle) {
        for (Dvd dvd : dvds.values()) {
            if (dvd.getDirectorId() == directorId && dvd.getTitle().equals(dvdTitle)) {
                return dvd;
            }
        }
        return null;
    }

    @Override
    public void save(Dvd dvd) {
        int id = generateUniqueId();
        dvd.setId(id);
        dvds.put(id, dvd);
    }

    @Override
    public List<Dvd> findByDvdIds(List<Integer> dvdIds) {
        List<Dvd> foundDvds = new ArrayList<>();
        for (Integer dvdId : dvdIds) {
            Dvd dvd = dvds.get(dvdId);
            if (dvd != null) {
                foundDvds.add(dvd);
            }
        }
        return foundDvds;
    }

    private int generateUniqueId() {
        return ++counter;
    }
}

class DirectorRepository implements DirectorRepo {
    private Map<Integer, Director> directors = new HashMap<>();

    @Override
    public boolean checkDirectorId(int directorId) {
        return directors.containsKey(directorId);
    }

    @Override
    public Director save(Director director) {
        directors.put(director.getDirectorId(), director);
        return director;
    }
}

class Dvd {
    private int id;
    private int directorId;
    private String title;
    private String producer;
    private LocalDate released;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDirectorId() {
        return directorId;
    }

    public void setDirectorId(int directorId) {
        this.directorId = directorId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public LocalDate getReleased() {
        return released;
    }

    public void setReleased(LocalDate released) {
        this.released = released;
    }

    @Override
    public String toString() {
        return "DVD{" +
                "id=" + id +
                ", idSutradara=" + directorId +
                ", judul='" + title + '\'' +
                ", produser='" + producer + '\'' +
                ", tanggalRilis=" + released +
                '}';
    }
}

class Director {
    private int directorId;
    private String name;

    public int getDirectorId() {
        return directorId;
    }

    public void setDirectorId(int directorId) {
        this.directorId = directorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class DvdService {
    private final DvdRepo dvdRepo;
    private final DirectorService directorService;

    public DvdService(DvdRepo dvdRepo, DirectorService directorService) {
        this.dvdRepo = dvdRepo;
        this.directorService = directorService;
    }

    public void saveDvd(int directorId, String dvdTitle, String producer) throws Exception {
        validateDvd(directorId, dvdTitle);
        directorService.saveIfNotExist(directorId);
        String producerName = getProducerName(producer);

        Dvd dvd = new Dvd();
        dvd.setDirectorId(directorId);
        dvd.setTitle(dvdTitle);
        dvd.setProducer(producerName);
        dvdRepo.save(dvd);
    }

    private String getProducerName(String producer) {
        return producer != null ? producer : "Anonim";
    }

    private void validateDvd(int directorId, String dvdTitle) throws Exception {
        if (dvdTitle == null)
            throw new Exception("Judul DVD kosong");
        Dvd dvdByDirectorIdAndDvdTitle = dvdRepo.findByDirectorIdAndDvdTitle(directorId, dvdTitle);
        if (dvdByDirectorIdAndDvdTitle != null) {
            throw new Exception("DVD Duplikat");
        }
    }

    public Map<Integer, List<Dvd>> rilisDvdBerdasarkanSutradara(List<Integer> dvdIds) {
        List<Dvd> dvds = updateRilisDvd(dvdIds);
        return grupDvdBerdasarkanSutradara(dvds);
    }

    private Map<Integer, List<Dvd>> grupDvdBerdasarkanSutradara(List<Dvd> dvds) {
        Map<Integer, List<Dvd>> dvdsByDirector = new HashMap<>();
        for (Dvd dvd : dvds) {
            int directorId = dvd.getDirectorId();
            List<Dvd> dvdList = dvdsByDirector.getOrDefault(directorId, new ArrayList<>());
            dvdList.add(dvd);
            dvdsByDirector.put(directorId, dvdList);
        }
        return dvdsByDirector;
    }

    private List<Dvd> updateRilisDvd(List<Integer> dvdIds) {
        List<Dvd> dvds = dvdRepo.findByDvdIds(dvdIds);
        for (Dvd dvd : dvds) {
            dvd.setReleased(LocalDate.now());
        }
        return dvds;
    }
}

class DirectorService {
    private final DirectorRepo directorRepo;

    public DirectorService(DirectorRepo directorRepo) {
        this.directorRepo = directorRepo;
    }

    public void saveIfNotExist(int directorId) {
        boolean existedDirector = directorRepo.checkDirectorId(directorId);
        if (!existedDirector) {
            Director director = new Director();
            director.setName("Tidak Diketahui");
            director.setDirectorId(directorId);
            directorRepo.save(director);
        }
    }
}

class Main {
    public static void main(String[] args) {
        DvdRepo dvdRepo = new DvdRepository();
        DirectorRepo directorRepo = new DirectorRepository();
        DirectorService directorService = new DirectorService(directorRepo);
        DvdService dvdService = new DvdService(dvdRepo, directorService);

        try {
            dvdService.saveDvd(1, "The Shawshank Redemption", "Castle Rock Entertainment");
            dvdService.saveDvd(2, "The Godfather", "Paramount Pictures");
            dvdService.saveDvd(3, "The Dark Knight", "Warner Bros.");
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<Integer> dvdIds = List.of(1, 2, 3);
        Map<Integer, List<Dvd>> dvdsByDirector = dvdService.rilisDvdBerdasarkanSutradara(dvdIds);

        for (Map.Entry<Integer, List<Dvd>> entry : dvdsByDirector.entrySet()) {
            int directorId = entry.getKey();
            List<Dvd> dvds = entry.getValue();
            System.out.println("Sutradara ID: " + directorId);
            for (Dvd dvd : dvds) {
                System.out.println("\t" + dvd);
            }
        }
    }
}