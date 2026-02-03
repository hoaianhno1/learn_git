package PersonalFinance;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class Demo {

    enum TxType { IN, OUT }

    static class Transaction {
        private final long id;
        private final long amount;
        private final TxType type;
        private final String category;
        private final LocalDateTime occurredAt;
        private final String note;

        public Transaction(long id, long amount, TxType type, String category, LocalDateTime occurredAt, String note) {
            if (amount <= 0) throw new IllegalArgumentException("amount must be positive");
            if (type == null) throw new IllegalArgumentException("type is required");
            if (category == null || category.isBlank()) throw new IllegalArgumentException("category is required");
            if (occurredAt == null) throw new IllegalArgumentException("occurredAt is required");

            this.id = id;
            this.amount = amount;
            this.type = type;
            this.category = category.trim().toLowerCase();
            this.occurredAt = occurredAt;
            this.note = note == null ? "" : note.trim();
        }

        public long getId() { return id; }
        public long getAmount() { return amount; }
        public TxType getType() { return type; }
        public String getCategory() { return category; }
        public LocalDateTime getOccurredAt() { return occurredAt; }
        public String getNote() { return note; }
    }

    static class MonthlySummary {
        private final long totalIn;
        private final long totalOut;

        public MonthlySummary(long totalIn, long totalOut) {
            this.totalIn = totalIn;
            this.totalOut = totalOut;
        }

        public long getTotalIn() { return totalIn; }
        public long getTotalOut() { return totalOut; }
        public long getNet() { return totalIn - totalOut; }
    }

    public static void main(String[] args) {
        List<Transaction> txs = List.of(
                new Transaction(1, 120_000, TxType.OUT, "cafe", LocalDateTime.of(2026, 2, 1, 9, 10), "Highlands"),
                new Transaction(2, 55_000, TxType.OUT, "food", LocalDateTime.of(2026, 2, 1, 12, 30), "Com tam"),
                new Transaction(3, 2_000_000, TxType.OUT, "rent", LocalDateTime.of(2026, 2, 1, 20, 0), "Nha thang 2"),
                new Transaction(4, 300_000, TxType.IN, "salary", LocalDateTime.of(2026, 2, 2, 9, 0), "Freelance"),
                new Transaction(5, 89_000, TxType.OUT, "transport", LocalDateTime.of(2026, 2, 2, 18, 10), "Grab"),
                new Transaction(6, 150_000, TxType.OUT, "food", LocalDateTime.of(2026, 2, 3, 19, 40), "Lau ga")
        );

        MonthlySummary summary = calcSummary(txs);

        System.out.println("Total IN:  " + summary.getTotalIn());
        System.out.println("Total OUT: " + summary.getTotalOut());
        System.out.println("Net:       " + summary.getNet());
        System.out.println();

        Map<String, Long> outByCategory = calcOutByCategory(txs);

        System.out.println("Top categories by OUT:");
        outByCategory.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .forEach(e -> System.out.println("  " + e.getKey() + ": " + e.getValue()));
    }

    static MonthlySummary calcSummary(List<Transaction> txs) {
        long totalIn = txs.stream()
                .filter(t -> t.getType() == TxType.IN)
                .mapToLong(Transaction::getAmount)
                .sum();

        long totalOut = txs.stream()
                .filter(t -> t.getType() == TxType.OUT)
                .mapToLong(Transaction::getAmount)
                .sum();

        return new MonthlySummary(totalIn, totalOut);
    }

    static Map<String, Long> calcOutByCategory(List<Transaction> txs) {
        return txs.stream()
                .filter(t -> t.getType() == TxType.OUT)
                .collect(Collectors.groupingBy(Transaction::getCategory, Collectors.summingLong(Transaction::getAmount)));
    }
}

