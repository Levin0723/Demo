package declarative.transaction.com;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * DAO实现类
 * Created by 黄桂道 on 2017-2-8.
 */
public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {
    @Override
    public void outMoney(String out, Double money) {
        String sql = " UPDATE account SET money = money - ? WHERE name = ? ";
        this.getJdbcTemplate().update(sql,money,out);

    }

    @Override
    public void inMoney(String in, Double money) {
        String sql = " UPDATE account SET money = money + ? WHERE name = ? ";
        this.getJdbcTemplate().update(sql,money,in);
    }
}
