-- this script is an exilirily script to compibe the data results from (pricePredictor.pig) and join it to the initail set
-- To Run the script
-- pig -x local -f aggregator.pig -param filename=file.csv

REGISTER '../../../lib/elasticsearch-hadoop-pig.jar';
define EsStorage org.elasticsearch.hadoop.pig.EsStorage('es.resource=test/seq');

store results into 'test/seq' USING EsStorage('es.http.timeout = 5m      es.index.auto.create = false');