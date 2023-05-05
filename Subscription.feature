Feature: Subscription

  Scenario: Subscription fail with wrong format email
    Given Home screen should be showed
    When The user input email "nha@gmail"
    Then The message "* Email không đúng định dạng" will be showed
    And the email field have color border is red

  Scenario: Subscription fail with exist email
    Given Home screen should be showed
    When The user input email "khanh.tx@live.com"
    Then The alert "E-mail khanh.tx@live.com đã được sử dụng, bạn hãy chọn một E-mail khác" will be showed

  Scenario: Subscription with valid email
    Given Home screen should be showed
    When The user input email "nha@gmail.com"
    Then The popup "Để phục vụ bạn được tốt hơn, bạn vui lòng cung cấp thêm các thông tin bên dưới." will be showed
    And the gender dropbox show the default value is "Không xác định"
    And the news dropbox  show the default value is "Nhận tất cả các loại tin"
    And the name textbox is required

  Scenario: Subscription fail with empty name
    Given Home screen should be showed
    When The user input email "nha@gmail.com"
    And The user attempt to subscribe with no data at the name textbox
    Then The error message "* Bạn cần phải nhập dữ liệu" will be showed
    And user will see the name field have color border is red and background color is yellow


  Scenario: Subscription success with valid data
    Given Home screen should be showed
    When The user input email "nha56432112@gmail.com"
    And The user fills in the information with full name "Pham Thanh Nha", gender is "Nữ" and news is "Thông tin khai giảng khóa học"
    Then the user will see the success popup "Bạn đã đăng ký nhận bản tin thành công. Hãy kiểm tra Email để xác nhận việc đăng ký"

