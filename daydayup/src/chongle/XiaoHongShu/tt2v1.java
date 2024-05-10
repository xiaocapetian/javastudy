package chongle.XiaoHongShu;

import java.util.*;
/*
2 5
red book game music sigma
mozart 3
book classic music
arcaea 2
red music
* */
public class tt2v1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取输入的关键词数量和商品数量
        int n = scanner.nextInt();//商品数量
        int g = scanner.nextInt();//关键词数量

        // GuanGianCiMap,关键词,
        List<String> keywords = new ArrayList<>();
        for (int i = 0; i < g; i++) {
            keywords.add(scanner.next());
        }

        // 存储商品及其命中关键词数量的映射[你看这里直接存一个商品和它中了多少词就行了]
        Map<String, Integer> hitsMap = new HashMap<>();

        // 处理每个商品
        for (int i = 0; i < n; i++) {
            String productName = scanner.next();//Name
            int keywordCount = scanner.nextInt();
            int hits = 0; // 商品命中的关键词数量

            // 统计商品命中的关键词数量
            for (int j = 0; j < keywordCount; j++) {
                String keyword = scanner.next();
                if (keywords.contains(keyword)) {//只要存在就++
                    hits++;
                }
            }

            // 将商品及其命中关键词数量存储到映射中
            hitsMap.put(productName, hits);
        }

        // 根据命中关键词数量降序排序商品列表
        List<Map.Entry<String, Integer>> sortedHits = new ArrayList<>(hitsMap.entrySet());
        sortedHits.sort((a, b) -> b.getValue() - a.getValue());

        // 输出排序后的结果
        for (Map.Entry<String, Integer> entry : sortedHits) {
            System.out.println(entry.getKey());
        }
    }
}
