import java.util.*;

public class User {
  private String userName;
  private boolean online;
  private List<Song> songList;

  public User()  { this(""); }
  
  public User(String u)  {
    userName = u;
    online = false;
    songList = new ArrayList<>();
  }

  public List<Song> getSongList() { return songList; }
  public String getUserName() { return userName; }
  public boolean isOnline() { return online; }
  
  public String toString()  {
    String s = "" + userName + ": " + songList.size() + " songs (";
    if (!online) s += "not ";
    return s + "online)";
  }

  public void addSong(Song s) {
      songList.add(s);
      s.setOwner(this);
  }

  public int totalSongTime() {
    int time = 0;
    for(Song i: songList) {
      time += i.getSeconds();
    }
    return time;
  }

  public void register(MusicExchangeCenter m) {
    m.registerUser(this);
  }

  public void logon() {
    online = true;
  }

  public void logoff() { online = false; }

  public List<String> requestCompleteSonglist(MusicExchangeCenter m) {
    List<String> completeSogList = new ArrayList<>();
    completeSogList.add(String.format("%3s %-26s %-14s %-7s", "", "TITLE", "ARTIST", " TIME    OWNER"));
    completeSogList.add("");
    int counter = 1;

    for(User j: m.onlineUsers()) {
      for(Song k: j.getSongList()) {
        completeSogList.add(String.format("%2d. %-26s %-14s %2d:%02d %-7s", counter, k.getTitle(), k.getArtist(), k.getMinutes(), k.getSeconds(), "   " + j.getUserName()));
        counter++;
      }
    }
    return completeSogList;
  }

  public List<String> requestSonglistByArtist(MusicExchangeCenter m, String artist) {
    List<String> songListByArtist = new ArrayList<>();
    songListByArtist.add("\t" + String.format("%6s %-26s %-14s %-7s", "", "TITLE", "ARTIST", " TIME    OWNER"));
    songListByArtist.add("");
    int counter = 1;

    for(User i: m.onlineUsers()) {
      for(Song k: i.getSongList()) {
        if(k.getArtist().equals(artist)) {
          songListByArtist.add("\t" + String.format("%5d. %-26s %-14s %2d:%02d %-7s", counter, k.getTitle(), k.getArtist(), k.getMinutes(), k.getSeconds(), "   " + i.getUserName()));
          counter ++;
        }
      }
    }
    return songListByArtist;
  }

  public void downloadSong(MusicExchangeCenter m, String title, String ownerName) {
    Song song = m.getSong(title, ownerName);
    if(song != null) {
      songList.add(song);
    }
  }

  public Song songWithTitle(String title) {
    for (Song i : songList) {
      if (i.getTitle().equals(title)) {
        return i;
      }
    }
    return null;
  }
}
