package com.sts;

import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import com.sts.controller.usercontrollar;
import com.sts.model.Product;
import com.sts.services.ProductRepo;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

    @Mock
    private ProductRepo studentRepository;
    @InjectMocks
    private usercontrollar studentService;
    private AutoCloseable autoCloseable;

    StudentServiceTest() {
    }

    @BeforeEach
    void setUp() {
        this.autoCloseable = MockitoAnnotations.openMocks(this);
        this.studentService = new usercontrollar();
    }

    @AfterEach
    void tearDown() throws Exception {
        this.autoCloseable.close();
    }

    @Test
    void addStudent() {
        Product student = new Product(110, "sanjida","Samanta","abc@gmail.com");
        this.studentService.addStudent(student);
        ArgumentCaptor<Product> captor = ArgumentCaptor.forClass(Product.class);
        ((ProductRepo) Mockito.verify(this.studentRepository)).save((Product)captor.capture());
        Product captured = (Product)captor.getValue();
        AssertionsForClassTypes.assertThat(captured).isEqualTo(student);
    }

    @Test
    void getStudentById() {
        int id = 2;
        Optional<Product> getStudents = this.studentRepository.findById(id);
        ((ProductRepo)Mockito.verify(this.studentRepository)).findById(id);
        AssertionsForClassTypes.assertThat(Optional.empty()).isEqualTo(getStudents);
    }

    @Test
    void deleteStudent() {
        int exstingId = 110;
        this.studentRepository.deleteById(exstingId);
        ((ProductRepo)Mockito.verify(this.studentRepository)).deleteById(exstingId);
    }
}