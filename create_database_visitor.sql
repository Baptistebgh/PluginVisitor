DROP TABLE IF EXISTS lutece_visitor;
CREATE TABLE lutece_visitor(
    id_visitor INT NOT NULL auto_increment,
    plugin_name VARCHAR(255),
    metric_name VARCHAR(255),
    metric_value FLOAT,
    PRIMARY KEY (id_visitor)
)
