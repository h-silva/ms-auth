alter table cdt_user add column if not exists created_at timestamp default now();
alter table cdt_user add column if not exists updated_at timestamp default now();