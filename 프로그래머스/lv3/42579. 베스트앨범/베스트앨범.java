import java.util.*;

class Solution {
    static class Song{
        String genre;
        int play;
        int num;

        public Song(String genre, int play, int num) {
            this.genre = genre;
            this.play = play;
            this.num = num;
        }
    }
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, List<Song>> songs = new HashMap<>();
        HashMap<String, Integer> total = new HashMap<>();
        List<Integer> bestAlbum = new ArrayList<>();

        int len = genres.length;

        for (int i = 0; i < len; i++) {
            if (!songs.containsKey(genres[i])) {
                songs.put(genres[i], new ArrayList<>());
                songs.get(genres[i]).add(new Song(genres[i],plays[i], i));
            } else {
                songs.get(genres[i]).add(new Song(genres[i],plays[i], i));
            }

            total.put(genres[i], total.getOrDefault(genres[i], 0) + plays[i]);
        }

        for (String key : songs.keySet()) {
            Collections.sort(songs.get(key), new Comparator<Song>() {
                @Override
                public int compare(Song o1, Song o2) {
                    if (o1.play == o2.play) {
                        return o1.num - o2.num;
                    }
                    return o2.play - o1.play;
                }
            });
        }
        System.out.println(total);

        List<Map.Entry<String, Integer>> sortedTotal = new ArrayList<>(total.entrySet());

        sortedTotal.sort(Map.Entry.comparingByValue(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        }));

        System.out.println(sortedTotal);

        for (Map.Entry<String,Integer> entry : sortedTotal) {
            int cnt = 0;

            for (Song song : songs.get(entry.getKey())) {
                bestAlbum.add(song.num);
                cnt++;
                if (cnt == 2) {
                    break;
                }
            }
        }

        return bestAlbum.stream().mapToInt(i -> i).toArray();
    }
}