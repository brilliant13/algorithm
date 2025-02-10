import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        Person[] p = new Person[T];

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            p[i] = new Person(age, name);
        }

        //Arrays.sort는 Stable sort. 입력순서는 유지된다.
        Arrays.sort(p, new Comparator<Person>() {
            @Override
            public int compare(Person s1, Person s2) {
                return s1.age - s2.age;
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            sb.append(p[i]);
        }
        System.out.println(sb);

    }

    private static class Person {
        int age;
        String name;

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return age + " " + name + "\n";
        }

    }
}