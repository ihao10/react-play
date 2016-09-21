package modules.bindings;

import com.youzu.topsango.shared.SystemConstantsKt;
import com.youzu.topsango.shared.configuration.ZkDataSourceConfigCache;
import com.youzu.topsango.shared.persistence.GameShardStrategiesKt;
import com.youzu.util.CommonDao;
import com.youzu.util.CommonDaoHibernate;
import kotlin.Unit;
import org.apache.curator.framework.CuratorFramework;

public class SlaveDbCache {

  private volatile CommonDao commonDao;

  private ZkDataSourceConfigCache dataSourceCache;

  public CommonDao getCommonDao() {
    return commonDao;
  }

  public ZkDataSourceConfigCache getDataSourceCache() {
    return dataSourceCache;
  }

  void init(CuratorFramework zookeeper) {
    dataSourceCache = new ZkDataSourceConfigCache(zookeeper, SystemConstantsKt.getZK_DATASOURCE_PATH(), configList -> {
      commonDao = new CommonDaoHibernate(GameShardStrategiesKt.buildGameShardedSessionFactory(configList.getDatasourceList()));
      return Unit.INSTANCE;
    });
  }
}
