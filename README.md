# Mapper
1. index
    1. SceneryMapper.xml,多表查询,增,删,改
        - 条件 if
        - 批量删除 foreach
        - 详细: `https://github.com/Hitokui12138/Practice/blob/main/5.SSM/0908%20MVC%E5%8E%9F%E7%90%86Mapper.md`
    2. 
2. 
3. 常见问题
    1. start_time下划线项目为null
        - 项目start_time生成的entity是startTime,setter叫做setStartTime()
    2. 两个表都有scename项目,导致主表的数据自动映射到子表上(使用别名)