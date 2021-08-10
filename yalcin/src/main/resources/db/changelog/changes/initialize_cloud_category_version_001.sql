insert into cloud_category (category)
Select 'Elektronik' Where not exists(select * from cloud_category where category='Elektronik');
insert into cloud_category (category)
Select 'Kitap' Where not exists(select * from cloud_category where category='Kitap');
insert into cloud_category (category)
Select 'Ofis' Where not exists(select * from cloud_category where category='Ofis');
insert into cloud_category (category)
Select 'Genel' Where not exists(select * from cloud_category where category='Genel');


