## Part A: Survived mutant-уудын ангилал

Эхний PIT ажиллуулалт: 63 mutation үүссэн, 17 killed, 46 survived (27%). Доорх хүснэгтэд 46 survived mutant-ийг шалтгаанаар нь нэгтгэж бичлээ.

| Мөр | Мутаци (PIT description) | Ангилал | Арга хэмжээ |
|---|---|---|---|
| 20 | changed conditional boundary (`score < 0`, `score > 100`) ×2 | Тест дутуу | -0.01 болон 100.01 оруулахад алдаа гарах тест нэмнэ; одоо зөвхөн -1, 101 шалгадаг тул хил нь шалгагдаагүй. |
| 23 | replaced return value with "", changed conditional boundary, removed conditional (true/false) ×4 | Тест дутуу | 90 → "A", 89.99 → "B" гэсэн яг утгын assert; одоо зөвхөн assertNotNull. |
| 24 | replaced return value with "", boundary, removed conditional (true/false) ×4 | Тест дутуу | 80 → "B", 79.99 → "C" хил болон яг утгын assert. |
| 25 | replaced return value with "", boundary, removed conditional (true/false) ×4 | Тест дутуу | 70 → "C", 69.99 → "D" хил болон яг утгын assert. |
| 26 | replaced return value with "", boundary, removed conditional (true/false) ×4 | Тест дутуу | 60 → "D", 59.99 → "F" хил болон яг утгын assert. |
| 27 | replaced return value with "" | Тест дутуу | 30 болон 0 дээр "F" гэж яг assertEquals хийнэ. |
| 36 | Changed switch default to be first case | Equivalent (сэжигтэй) | `default` нь зөвхөн `break` хийдэг, өөр case бүр нь өөрийн утгатай тул default-г эхэнд нь зөөхөд үр дүн өөрчлөгдөхгүй. B2-ийн дараах бодит PIT үр дүнгээр баталгаажуулна. |
| 38 | Replaced double addition with subtraction (case "B") | Тест дутуу | Зөвхөн "B" үсэгтэй нэг оноо бүхий gpa (85 → 3.0) тест; одоо range check тул илрэхгүй. |
| 40 | Replaced double addition with subtraction (case "D") | Тест дутуу | Зөвхөн "D" үсэгтэй gpa (65 → 1.0) тест. |
| 44 | replaced double return with 0.0 | Тест дутуу | gpa-ийн яг утга assertEquals(3.5, ..., delta); range check 0.0-г хүлээн зөвшөөрдөг байсан. |
| 48 | changed conditional boundary ×2, removed conditional (true) ×1 | Тест дутуу | gpa 0 ба 4.0 (зөвшөөрөгдөнө), -0.01 ба 4.01 (алдаа), credits 0 тестүүд. |
| 51 | removed conditional (equality check true/false) ×2 | Тест дутуу | `hasViolation = true` үед яг 0 буцаах, `false` үед шагнал олгогдохыг шалгах тест (одоо зөвхөн range check). |
| 52 | replaced int return with 0, boundary ×2, removed conditional ×4 | Тест дутуу | (3.8, 15) → 100, (3.8, 14) → 70, (3.79, 15) → 70 тест. |
| 53 | replaced int return with 0, boundary ×2, removed conditional ×4 | Тест дутуу | (3.4, 12) → 70, (3.4, 11) → 50, (3.39, 12) → 50 тест. |
| 54 | replaced int return with 0, boundary, removed conditional ×2 | Тест дутуу | (3.0, 0) → 50 ба (2.99, 20) → 0 тест. |
