package com.expertise.ebudget.budget.repository;

import com.expertise.ebudget.budget.entity.financing.FinancingBalanceByBudget;
import com.expertise.ebudget.budget.entity.nomenclature.NomenclatureBalanceByBudget;
import com.expertise.ebudget.budget.entity.subActivity.SubActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SubActivityRepository extends JpaRepository<SubActivity, Long> {

    //@Query("SELECT sa FROM SubActivity a WHERE sa.activity.id = :activityId")
    List<SubActivity> findByActivityId(Long activityId);

    @Query(value = "SELECT f.name AS financing, SUM(sa.frequency * sa.quantity * sa.unit_cost) AS total\n" +
            "FROM sub_activity sa\n" +
            "JOIN financing f ON sa.financing_id = f.id\n" +
            "JOIN activity a ON sa.activity_id = a.id\n" +
            "JOIN budget b ON a.budget_id = b.id\n" +
            "WHERE b.id = :budgetId\n" +
            "GROUP BY f.name", nativeQuery = true)
    List<FinancingBalanceByBudget> getBalanceByBudget(@Param("budgetId") Long budgetId);


//    @Query("""
//        SELECT
//            n.code AS code,
//            n.name AS libele,
//            f.name AS financing,
//            SUM(sa.frequency * sa.quantity * sa.unitCost) AS total
//        FROM SubActivity sa
//        JOIN sa.nomenclature n
//        JOIN sa.activity a
//        JOIN a.budget b
//        JOIN sa.financing f
//        WHERE b.id = :budgetId
//        GROUP BY n.code, n.name, f.name
//    """)

    @Query(value = "SELECT n.code AS code,n.name AS libele, f.name AS financing, SUM(sa.frequency * sa.quantity * sa.unit_cost) AS total\n" +
            "FROM sub_activity sa\n" +
            "JOIN nomenclature n ON sa.nomenclature_id = n.id\n" +
            "JOIN activity a ON sa.activity_id = a.id\n" +
            "JOIN budget b ON a.budget_id = b.id\n" +
            "JOIN financing f ON sa.financing_id = f.id\n" +
            "WHERE b.id = :budgetId\n" +
            "GROUP BY n.code, n.name, f.name", nativeQuery = true)
     List<NomenclatureBalanceByBudget> getNomenclatureBalanceByBudget(@Param("budgetId") long budgetId);
}
