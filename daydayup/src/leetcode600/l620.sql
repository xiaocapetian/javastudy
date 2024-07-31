select * from cinema where description != 'boring' and id%2=1 order by rating DESC;
-- 最后加一个DESC 表示要降序