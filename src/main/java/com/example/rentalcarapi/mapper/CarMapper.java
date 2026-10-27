package com.example.rentalcarapi.mapper;

import com.example.rentalcarapi.dto.Car;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CarMapper {

    @Select("SELECT * FROM cars ORDER BY id ASC")
    List<Car> findAll();

    @Insert("INSERT INTO cars (car_name, maker, number_plate, daily_price, capacity, status) VALUES (#{carName}, #{maker}, #{numberPlate}, #{dailyPrice}, #{capacity}, #{status})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insert(Car car);

    @Select("SELECT * FROM cars WHERE id = #{id}")
    Car findById(Long id);

    @Delete("DELETE FROM cars WHERE id = #{id}")
    int delete(Long id);

    @Update("UPDATE cars SET car_name = #{carName}, maker = #{maker}, number_plate = #{numberPlate}, daily_price = #{dailyPrice}, capacity = #{capacity}, status = #{status} WHERE id = #{id}")
    int update(Car car);
}