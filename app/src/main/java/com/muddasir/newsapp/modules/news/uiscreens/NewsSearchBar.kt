package com.muddasir.newsapp.modules.news.uiscreens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@ExperimentalMaterial3Api
@Composable
fun SearchWithList(
    allItems: List<String>,
    modifier: Modifier = Modifier,
    onItemClick: (String) -> Unit = {}
) {
    var query by remember { mutableStateOf("") }


    // Filtered items
    val filtered = remember(query, allItems) {
        val q = query.trim().lowercase()
        if (q.isBlank()) allItems else allItems.filter { it.lowercase().contains(q) }
    }

    Column(modifier = modifier.fillMaxSize()) {


        SearchBar(
            inputField = { TextField(value = query, onValueChange = { query = it }) },
            expanded = false,
            onExpandedChange = {},
            modifier = Modifier.fillMaxWidth(),
            shape = SearchBarDefaults.inputFieldShape,
            colors = SearchBarDefaults.colors(),
            tonalElevation = SearchBarDefaults.TonalElevation,
            shadowElevation = SearchBarDefaults.ShadowElevation,
            windowInsets = SearchBarDefaults.windowInsets,

            content = {
                LazyColumn {
                    items(filtered) { item ->
                        SuggestionRow(item = item) { onItemClick(it) }
                    }
                }
            },
        )
        // Material3 SearchBar (experimental
        // Main list below the bar
        HorizontalDivider()
        if (filtered.isEmpty()) {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text("No results", style = MaterialTheme.typography.bodyMedium)
            }
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(vertical = 8.dp)
            ) {
                items(filtered) { item ->
                    ListItem(
                        headlineContent = { Text(item) },
                        supportingContent = { Text("Subtitle for $item") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { onItemClick(item) }
                            .padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                    HorizontalDivider()
                }
            }
        }
    }
}

@Composable
private fun SuggestionRow(item: String, onClick: (String) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick(item) }
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            Icons.Default.Search,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Spacer(Modifier.width(8.dp))
        Text(item, style = MaterialTheme.typography.bodyMedium)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun SearchWithListPreview() {
    MaterialTheme(colorScheme = lightColorScheme()) {
        val sample = listOf(
            "Apple", "Apricot", "Banana", "Blackberry", "Blueberry", "Cherry",
            "Date", "Fig", "Grapes", "Guava", "Kiwi", "Lemon", "Mango",
            "Orange", "Papaya", "Peach", "Pear", "Pineapple", "Plum",
            "Raspberry", "Strawberry", "Watermelon"
        )
        SearchWithList(allItems = sample, onItemClick = {})
    }
}
