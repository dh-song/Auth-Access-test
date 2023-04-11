//package kr.co.rland.web.repository.mybatis;
//
//import java.util.List;
//
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import kr.co.rland.web.entity.Menu;
//import kr.co.rland.web.repository.MenuRepository;
//
////@Repository
//public class MbMenuRepository implements MenuRepository {
//	
//	//private SqlSessionFactory factory;
//	private SqlSession session;
//	private MenuRepository repository;
//	
//	public MbMenuRepository() {
//		// TODO Auto-generated constructor stub
//	}
//	
//	@Autowired
//	public MbMenuRepository(SqlSession session) {
//		super();
//		this.session = session;		
//		this.repository = session.getMapper(MenuRepository.class);
//	}
//
////	@Override
////	public List<Menu> findAll() {
////		//return repository.findAll(0,10,null,null,null,null,null);
////		return session.selectList("kr.co.rland.web.repository.MenuRepository.findAll");
////		
////	}
////	
////	@Override
////	public List<Menu> findAll(Integer offset, Integer size) {
////		//MenuRepository repository = session.getMapper(MenuRepository.class);
////		return repository.findAll(offset,size,null,null,null,null,null);
////	}
//	
//	@Override
//	public List<Menu> findAll(Integer offset, Integer size, String query, Integer categoryId, Integer price,
//			String orderField, String orderDir) {
//		//MenuRepository repository = session.getMapper(MenuRepository.class);
//		return repository.findAll(null,null,null,null,null,null,null);
//	}
//
//	@Override
//	public List<Menu> findAllByIds(List<Long> ids) {
//		// TODO Auto-generated method stub
//		//MenuRepository repository = session.getMapper(MenuRepository.class);
//		//List<Menu> list = session.selectList("kr.co.rland.web.repository.MenuRepository.findAllByIds", ids);
//		
//		return repository.findAllByIds(ids);
//	}
//
//	@Override
//	public Menu findById(long id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Menu insert(Menu menu) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Menu update(Menu menu) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void delete(long id) {
//		// TODO Auto-generated method stub
//
//	}
//
//}
