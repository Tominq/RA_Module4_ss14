package ra.ss14.daoImpl;

import org.springframework.stereotype.Component;
import ra.ss14.dao.IProductDao;
import ra.ss14.model.Product;
import ra.ss14.util.ConnectDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductDao implements IProductDao {

    @Override
    public List<Product> findAll() {
        Connection conn = ConnectDB.getConnection();
        List<Product> list = new ArrayList<>();
        try {
            CallableStatement callSt = conn.prepareCall("{call Proce_Find_All_Product()}");
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setImageUrl(rs.getString("imageUrl"));
                product.setPrice(rs.getDouble("price"));
                product.setDesc(rs.getString("description"));
                product.setStock(rs.getInt("stock"));
                product.setStatus(rs.getBoolean("status"));
                list.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectDB.closeConnection(conn);
        }
        return list;
    }

    @Override
    public Product findById(Integer id) {
        Connection conn = ConnectDB.getConnection();
        Product product = null;
        try {
            CallableStatement callSt = conn.prepareCall("{call Proce_Find_Product_By_Id(?)}");
            callSt.setInt(1,id);
            ResultSet rs = callSt.executeQuery();
            if (rs.next()){
                product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setImageUrl(rs.getString("imageUrl"));
                product.setPrice(rs.getDouble("price"));
                product.setDesc(rs.getString("description"));
                product.setStock(rs.getInt("stock"));
                product.setStatus(rs.getBoolean("status"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectDB.closeConnection(conn);
        }
        return product;
    }

    @Override
    public boolean save(Product product) {
        Connection conn = ConnectDB.getConnection();
        CallableStatement callSt = null;
            try {
                if (findById(product.getId()) == null) {
                    // thêm mới
                    callSt = conn.prepareCall("{call Proce_Insert_Product(?,?,?,?,?,?)}");
                    callSt.setString(1, product.getName());
                    callSt.setString(2, product.getImageUrl());
                    callSt.setDouble(3, product.getPrice());
                    callSt.setString(4, product.getDesc());
                    callSt.setInt(5, product.getStock());
                    callSt.setBoolean(6, product.isStatus());
                    callSt.executeUpdate();
                }else {
                    // cập nhật
                    callSt = conn.prepareCall("{call Proce_Update_Product_By_Id(?,?,?,?,?,?,?)}");
                    callSt.setInt(1, product.getId());
                    callSt.setString(2, product.getName());
                    callSt.setString(3, product.getImageUrl());
                    callSt.setDouble(4, product.getPrice());
                    callSt.setString(5, product.getDesc());
                    callSt.setInt(6, product.getStock());
                    callSt.setBoolean(7, product.isStatus());
                    callSt.executeUpdate();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                ConnectDB.closeConnection(conn);
            }
        return true;
    }

    @Override
    public void deleteById(Integer id) {
        Connection conn = ConnectDB.getConnection();
        try {
            CallableStatement callSt = conn.prepareCall("{call Proce_Delete_Product_By_Id(?) }");
            callSt.setInt(1, id);
            callSt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectDB.closeConnection(conn);
        }

    }
}
