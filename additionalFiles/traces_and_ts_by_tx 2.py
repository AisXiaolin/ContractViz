import json
import requests

def get_trace_and_timestamp(transaction_hash):
    # Replace with your Ethereum node's URL
    url = "http://localhost:8545"

    # 1. Get the traces
    trace_response = requests.post(url, json={
        "jsonrpc": "2.0",
        "method": "trace_transaction",
        "params": [transaction_hash],
        "id": 1
    }).json()

    traces = trace_response.get("result")
    if not traces:
        return {"error": "Transaction not found or traces unavailable"}

    # Extract block number from the trace response
    block_number_hex = traces[0].get("blockNumber")
    
    # 2. Get the block timestamp
    block_response = requests.post(url, json={
        "jsonrpc": "2.0",
        "method": "eth_getBlockByNumber",
        "params": [block_number_hex, False],
        "id": 1
    }).json()

    timestamp_hex = block_response["result"]["timestamp"]
    timestamp = int(timestamp_hex, 16)  # Convert hex timestamp to decimal

    # Combine results
    combined_result = {
        "transactionHash": transaction_hash,
        "blockNumber": block_number_hex,
        "timestamp": timestamp,
        "traces": traces
    }

    # Save to JSON file
    with open(f"{transaction_hash}_trace.json", "w") as f:
        json.dump(combined_result, f, indent=4)

    return combined_result

# Replace with your transaction hash
transaction_hash = "0xd70c784ca3000da707d29c662d3a5dbe3d6bbade73686e1c73b4a24979d9e8c4"
result = get_trace_and_timestamp(transaction_hash)
# print(json.dumps(result, indent=4))