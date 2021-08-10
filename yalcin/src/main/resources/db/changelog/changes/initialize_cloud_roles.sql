insert into cloud_roles (role)
Select 'ROLE_ADMIN' Where not exists(select * from cloud_roles where role='ROLE_ADMIN');
insert into cloud_roles (role)
Select 'ROLE_SELLER' Where not exists(select * from cloud_roles where role='ROLE_SELLER');
insert into cloud_roles (role)
Select 'ROLE_CUSTOMER' Where not exists(select * from cloud_roles where role='ROLE_CUSTOMER');

