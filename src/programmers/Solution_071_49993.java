package programmers;

public class Solution_071_49993 {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for (String skillTree : skill_trees) {
            StringBuilder filteredSb = new StringBuilder();
            for (char c : skillTree.toCharArray()) {
                if (skill.contains(String.valueOf(c))) {
                    filteredSb.append(c);
                }
            }
            if (skill.startsWith(filteredSb.toString())) {
                answer++;
            }
        }
        return answer;
    }
}
